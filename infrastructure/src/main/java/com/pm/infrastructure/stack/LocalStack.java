package com.pm.infrastructure.stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.amazon.awscdk.*;

public class LocalStack extends Stack {

    private static final Logger log = LoggerFactory.getLogger(LocalStack.class);

    public LocalStack(final App scope, final String id, final StackProps props){
        super(scope, id, props);
    }

    public static void main(String[] args){
        App app = new App(AppProps.builder().outdir("./cdk.out").build());
        StackProps props = StackProps.builder()
                .synthesizer(new BootstraplessSynthesizer())
                .build();

        new LocalStack(app, "localstack", props);
        app.synth();
        System.out.println("App synthesizing in progress....");
    }

}
