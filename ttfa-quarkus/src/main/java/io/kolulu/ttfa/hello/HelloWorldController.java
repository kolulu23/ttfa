package io.kolulu.ttfa.hello;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello-world")
public class HelloWorldController {

    @Inject
    @Named("harshWorldService")
    HelloWorldService helloWorldService;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String helloWorld() {
        String worldImpl = helloWorldService.getClass().getCanonicalName();
        return String.format("<p>You have found the world to be a <code>%s</code></p>", worldImpl);
    }

    @GET
    @Path("/greetings/{name}")
    @Produces({MediaType.TEXT_HTML, MediaType.TEXT_PLAIN})
    public String greetingsTo(@PathParam("name") String name) {
        return helloWorldService.greetings(name);
    }
}
