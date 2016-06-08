package com.polycom.sqa

import com.relevantcodes.extentreports.ExtentReports
import com.relevantcodes.extentreports.ExtentTest
import org.spockframework.runtime.AbstractRunListener
import org.spockframework.runtime.IRunListener
import org.spockframework.runtime.extension.IGlobalExtension
import org.spockframework.runtime.model.ErrorInfo
import org.spockframework.runtime.model.FeatureInfo
import org.spockframework.runtime.model.IterationInfo
import org.spockframework.runtime.model.SpecInfo

/**
 * Created by wgao on 5/25/2016.
 */
class ExtentReportExtension implements IGlobalExtension {

    ExtentReports currentTestRun

    @Override
    void start() {
        currentTestRun = new ExtentReports("build/extentreports/report.html", true)
    }

    @Override
    void visitSpec(SpecInfo specInfo) {
        specInfo.addListener createListener()
    }

    @Override
    void stop() {
        currentTestRun.close()
    }

    SpecInfoListener createListener() {
        new SpecInfoListener( currentTestRun )
    }
}

class SpecInfoListener extends AbstractRunListener {

    ExtentReports currentTestRun
    ExtentTest currentFeature

    SpecInfoListener( ExtentReports currentTestRun ) {
        this.currentTestRun = currentTestRun
    }

    @Override
    void beforeSpec(SpecInfo specInfo) {
        currentFeature = currentTestRun.startTest(specInfo.name)
    }

    @Override
    void beforeFeature(FeatureInfo featureInfo) {
        featureInfo.addIterationInterceptor(new ExtentReportInterceptor(currentTestRun, currentFeature))
    }

    @Override
    void afterSpec(SpecInfo specInfo) {
        currentTestRun.endTest(currentFeature)
        currentTestRun.flush()
    }
}