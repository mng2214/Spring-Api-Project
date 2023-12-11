package com.example.loadTests;

import org.apache.jmeter.config.gui.ArgumentsPanel;
import org.apache.jmeter.control.LoopController;
import org.apache.jmeter.control.gui.LoopControlPanel;
import org.apache.jmeter.control.gui.TestPlanGui;
import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jmeter.protocol.http.control.gui.HttpTestSampleGui;
import org.apache.jmeter.protocol.http.sampler.HTTPSampler;
import org.apache.jmeter.testelement.TestElement;
import org.apache.jmeter.testelement.TestPlan;
import org.apache.jmeter.threads.gui.ThreadGroupGui;
import org.apache.jmeter.util.JMeterUtils;
import org.apache.jorphan.collections.HashTree;
import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jmeter.protocol.http.sampler.HTTPSampler;
import org.apache.jmeter.protocol.http.control.HeaderManager;
import org.apache.jmeter.testelement.TestPlan;
import org.apache.jmeter.threads.ThreadGroup;

import org.apache.jmeter.util.JMeterUtils;
import org.apache.jorphan.collections.HashTree;
import org.apache.jorphan.collections.ListedHashTree;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.jmeter.reporters.ResultCollector;
import org.apache.jmeter.reporters.Summariser;
import org.apache.jmeter.save.SaveService;
import org.apache.jmeter.reporters.ResultCollector;
import org.apache.jmeter.reporters.Summariser;
import org.apache.jmeter.save.SaveService;

import java.io.FileOutputStream;
import java.io.IOException;

public class TestExample {
    public static void main(String[] args) throws IOException {


        // Create the Jmeter engine
        StandardJMeterEngine jm = new StandardJMeterEngine();

        // Set JMeter Home
        String jmeterHome = "C:\\Users\\mng22\\Desktop\\jemeter";
        JMeterUtils.setJMeterHome(jmeterHome);
        JMeterUtils.loadJMeterProperties(jmeterHome + "\\bin\\jmeter.properties");
        JMeterUtils.initLocale();

        // Create a new hash tree to hold our test elements
        HashTree testPlanTree = new HashTree();

        // Create HTTP Sampler
        HTTPSampler httpSampler = new HTTPSampler();
        httpSampler.setProtocol("http");
        httpSampler.setDomain("localhost");
        httpSampler.setPort(8081);
        httpSampler.setPath("/allusers");
        httpSampler.setMethod("GET");
        httpSampler.setProperty(TestElement.TEST_CLASS, HTTPSampler.class.getName());
        httpSampler.setProperty(TestElement.GUI_CLASS, HttpTestSampleGui.class.getName());


        // Create a loop controller
        LoopController loopController = new LoopController();
        loopController.setLoops(10);
        loopController.setFirst(true);
        loopController.setProperty(TestElement.TEST_CLASS, LoopController.class.getName());
        loopController.setProperty(TestElement.GUI_CLASS, LoopControlPanel.class.getName());
        loopController.initialize();

        // Create a thread group
        ThreadGroup threadGroup = new ThreadGroup();
        threadGroup.setName("Example Thread Group");
        threadGroup.setNumThreads(3);
        threadGroup.setRampUp(1);
        threadGroup.setSamplerController(loopController);
        threadGroup.setProperty(TestElement.TEST_CLASS, ThreadGroup.class.getName());
        threadGroup.setProperty(TestElement.GUI_CLASS, ThreadGroupGui.class.getName());

        // Create a test plan
        TestPlan testPlan = new TestPlan("Create JMeter Script From Java Code");
        testPlan.setProperty(TestElement.TEST_CLASS, TestPlan.class.getName());
        testPlan.setProperty(TestElement.GUI_CLASS, TestPlanGui.class.getName());
        testPlan.setUserDefinedVariables((Arguments) new ArgumentsPanel().createTestElement());

        // Add the test plan to our hash tree, this is the top level of our test
        testPlanTree.add(testPlan);

        // Create another hash tree and add the thread group to our test plan
        HashTree threadGroupHashTree = testPlanTree.add(testPlan, threadGroup);

        // Add the http sampler to the hash tree that contains the thread group
        threadGroupHashTree.add(httpSampler);

        // Configure
        jm.configure(testPlanTree);

        ////        // Run
        jm.run();


//        // Create a ResultCollector to collect test results
//        ResultCollector resultCollector = new ResultCollector(new Summariser());
//        resultCollector.setFilename("C:\\Users\\mng22\\Desktop\\jemeter\\Results"); // Specify the filename for the results
//
//        // Add the ResultCollector to the test plan tree
//        testPlanTree.add(testPlan, resultCollector);
//
//        // Configure JMeter
//        jm.configure(testPlanTree);
//
//        // Run the test
//        jm.run();
//
//        // Save the results to a file (optional)
//        SaveService.saveTree(testPlanTree, new FileOutputStream("test-plan.jmx"));
    }



    }


