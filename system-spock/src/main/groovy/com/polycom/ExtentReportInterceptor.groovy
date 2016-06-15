package com.polycom

import com.relevantcodes.extentreports.ExtentReports
import com.relevantcodes.extentreports.ExtentTest
import org.spockframework.runtime.extension.IMethodInterceptor
import org.spockframework.runtime.extension.IMethodInvocation

/**
 * Created by wgao on 5/25/2016.
 */
class ExtentReportInterceptor implements IMethodInterceptor {

    ExtentReports currentTestRun
    ExtentTest currentFeature

    ExtentReportInterceptor(ExtentReports currentTestRun, ExtentTest currentFeature) {
        this.currentTestRun = currentTestRun
        this.currentFeature = currentFeature
    }

    @Override
    void intercept(IMethodInvocation iMethodInvocation) throws Throwable {
        ExtentTest currentCase = currentTestRun.startTest(iMethodInvocation.feature.name)
        iMethodInvocation.iteration.metaClass.currentCase = currentCase
        iMethodInvocation.proceed()
        currentFeature.appendChild(currentCase)
    }
}
