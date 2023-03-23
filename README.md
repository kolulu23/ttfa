# TTFA: The Twelve Factor Apps Demo Project

Demonstration of [The Twelve-Factor App](https://12factor.net/codebase) using various web frameworks.

The web frameworks are applicable to do a lot of things, but to keep it simple, the demo apps are just CRUD RestApi HTTP Servers.

# Purpose

After all these years, I still don't get why there are still web frameworks coming out.

Normally, you should stick with what you already have, and in Java world, the simple answer is to use `SpringBoot` all
the way.

But what about others? Well you got `Quarkus`, `Micronaut` and even `Vert.x Web` if you like to take detours.
They present different flavours and approaches to build a web service/application, but trust me,
framework doesn't matter, or at least it doesn't matter until you start to write one.

So why this project? Honestly I just think [The Twelve-Factor App](https://12factor.net/codebase) is a good idea for
people
new to web programming in general, and I mostly write Java these days, so I decide give each framework a try, see how
well
they can do when it comes to implementing those factors.

It's not about how they utilize resources or how performant they can get, but primarily to demonstrate their API and
idiomatic usages.
And most importantly, see how I like them.

## Framework Choice

To call it a framework, it certainly must have similar abstraction level to the well known `SpringBoot` otherwise it's
unfair  to compare them. And the framework must have some userbase otherwise I don't know where to copy-paste.

So the candidates are:

1. SpringBoot, the "baseline" of building services
2. Quarkus, for it is hyped(in a good way?)
3. Micronaut, I have seen some projects using it and interested

other frameworks may get added in the future.

## Disclaimer

The comments I made on those frameworks is totally biased and based on my personal view and experience with it.
If you don't like it, feel free to mock me and my codestyle.

# The Factors

| Factor                                                        | What is it                                                       |
|---------------------------------------------------------------|------------------------------------------------------------------|
| [Codebase](https://12factor.net/codebase)                     | One codebase tracked in revision control, many deploys           |
| [Dependencies](https://12factor.net/dependencies)             | Explicitly declare and isolate dependencies                      |
| [Config](https://12factor.net/config)                         | Store config in the environment                                  |
| [Backing services](https://12factor.net/backing-services)     | Treat backing services as attached resources                     |
| [Build, release, run](https://12factor.net/build-release-run) | Strictly separate build and run stages                           |
| [Processes](https://12factor.net/processes)                   | Execute the app as one or more stateless processes               |
| [Port binding](https://12factor.net/port-binding)             | Export services via port binding                                 |
| [Concurrency](https://12factor.net/concurrency)               | Scale out via the process model                                  |
| [Disposability](https://12factor.net/disposability)           | Maximize robustness with fast startup and graceful shutdown      |
| [Dev/prod parity](https://12factor.net/dev-prod-parity)       | Keep development, staging, and production as similar as possible |
| [Logs](https://12factor.net/logs)                             | Treat logs as event streams                                      |
| [Admin processes](https://12factor.net/admin-processes)       | Run admin/management tasks as one-off processes                  |

In general, since all the codebase is version controled with Git, so they all pass the first factor check.

As for "dependencies", all frameworks are build with maven and packaged as fat jar, so the real extra dependency is just the JVM runtime. Code dependencies are declared and managed with maven's profile and dependencyManagement tag. Anyways this factor is more oriented towards build system selection rather than frameworks.

For "configs", they are all alike, file based config and remote config are all supported.

For "backing services", I am using only sqlite as application backing service when its possible. And it can be easily configured by both of them frameworks.

For "build, release, run", aforementioned maven features helps us build into unified form of artifact, and I will add git commit id into the jar(`git-commit-id-plugin`). To me this one is more related to CI, since it's a github repo, I can utilize github release tags and actions to further stress this factor.

For "processes", build stateless application with these featuer rich frameworks is easy, like that was easy button level of easiness. As you can see, they are stateless by default before adding any application logic. States can be stored and retrieved from backing services, we just need to introduce another dependency.

For "port binding", in its simplest form, any http server implementation can do so, and through a peiece configuration, web frameworks pass this check easily.

For "concurrency", this one is also barely a labour for our framwork picks, they are built to be a single java process and they _almost_ never manage system level processes by itself. Concurrency factor is meant to be scale application deployment, the name is misleading as when we talk about concurrency of java web backends we usually just think about threads.

For "disposability", java applications are notoriously slow to start, and when it is containerized to acheived max disposability the total startup time will only get worse. Speaking of containerized java applications, quarkus has made its point.

For "Dev/prod parity", we can use the same CICD approach with different profiles, this means which application works more smoothly with CICD platform/workflow gets more points. As to keep `prod` as close as `dev`, it will get harder when the application requires more backink services. Luckily there is kubernetes for container orchestration, but kubernetes itself may requires you to be fluent with more cloud native jargons. If you are just one man developer, better stick with some cloud services. Anyway, in todays world, this factor can be automatically obtained.

For "Logs", we are actually seeking an extensive solution works with all applications. If it is just locally logging in java web applications, you got the one-two punch of `slf4j+log4j2/logback impl`. But this topic can be stretched to a wider realm, like tracing, telemetry, monitoring and alerting. Setup those is kind of a trivial job but requires experiences with various of softwares: greylog, skywalker, open-tracing, zipkin, prometheus, just to name a few.

For "Admin processes", again, make containerized application. There're other solutions of course, but I am not familiar with those.

# Conclusion
The trend is clear, developing web backends have never been this easy as well as complicated as of today. 
More importantly, framework doesn't matter if you just want to make a 12 factor application.
