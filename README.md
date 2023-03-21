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
4. Vert.x Web, never used it but want to try it for a long time,
   though it is debatable to be on the list since the abstraction level it provides is relatively low

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

