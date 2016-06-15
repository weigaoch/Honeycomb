package com.polycom

import groovy.test.GroovyAssert

import com.relevantcodes.extentreports.ExtentTest
import com.relevantcodes.extentreports.LogStatus
import spock.lang.Specification

/**
 * Created by wgao on 5/25/2016.
 */
class SystemTestSpec extends Specification {

    def void step( stepDesp, actions)  {
        ExtentTest currentCase = this.specificationContext.currentIteration.currentCase
        try {
            actions()
            currentCase.log(LogStatus.PASS, stepDesp, "");
        } catch (Throwable e) {
            currentCase.log(LogStatus.FAIL, stepDesp, e)
            throw e
        }
    }

    protected Throwable shouldFail(Closure code) {
        return GroovyAssert.shouldFail(code);
    }

    protected Throwable shouldFail(Class clazz, Closure code) {
        return GroovyAssert.shouldFail(clazz, code);
    }

    protected Throwable shouldFailWithCause(Class clazz, Closure code) {
        return GroovyAssert.shouldFailWithCause(clazz, code);
    }

    protected Throwable shouldFail(Class clazz, String script) {
        return GroovyAssert.shouldFail(clazz, script);
    }

    protected Throwable shouldFail(String script) {
        return GroovyAssert.shouldFail(script);
    }

}
