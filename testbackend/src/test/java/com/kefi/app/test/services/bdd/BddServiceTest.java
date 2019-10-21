package com.kefi.app.test.services.bdd;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

import com.kefi.app.DemoTestApplication;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/services")
public class BddServiceTest {

}
