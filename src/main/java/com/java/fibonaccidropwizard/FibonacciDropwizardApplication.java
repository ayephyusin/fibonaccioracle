package com.java.fibonaccidropwizard;

import com.java.fibonaccidropwizard.controller.FibonacciController;

import io.dropwizard.Application;
import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.ws.rs.client.Client;

import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class FibonacciDropwizardApplication extends Application<FibonacciDropwizardConfiguration> {
	private static final Logger LOGGER = LoggerFactory.getLogger(FibonacciDropwizardApplication.class);
    public static void main(final String[] args) throws Exception {
        new FibonacciDropwizardApplication().run(args);
    }

//    @Override
//    public String getName() {
//        return "FibonacciDropwizard";
//    }

    @Override
    public void initialize(final Bootstrap<FibonacciDropwizardConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final FibonacciDropwizardConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
    	LOGGER.info("Registering REST resources");
    	environment.jersey().register(new FibonacciController(environment.getValidator()));
    	
//    	final Client client = new JerseyClientBuilder(environment)
//				.build("DemoRESTClient");
//    	environment.jersey().register(new FibonacciRestController(client));
    	configureCors(environment);
    }
    private void configureCors(Environment environment) {
        final FilterRegistration.Dynamic cors =
                environment.servlets().addFilter("CORS", CrossOriginFilter.class);

        // Configure CORS parameters
        cors.setInitParameter(CrossOriginFilter.ALLOWED_ORIGINS_PARAM, "*");
        cors.setInitParameter(CrossOriginFilter.ALLOWED_HEADERS_PARAM, "X-Requested-With,Content-Type,Accept,Origin,Authorization");
        cors.setInitParameter(CrossOriginFilter.ALLOWED_METHODS_PARAM, "OPTIONS,GET,PUT,POST,DELETE,HEAD");
        cors.setInitParameter(CrossOriginFilter.ALLOW_CREDENTIALS_PARAM, "true");

        // Add URL mapping
        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");

    }

}
