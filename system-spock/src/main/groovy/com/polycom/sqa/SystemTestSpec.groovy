package com.polycom.sqa

import com.relevantcodes.extentreports.ExtentTest
import com.relevantcodes.extentreports.LogStatus
import spock.lang.Specification

/**
 * Created by wgao on 5/25/2016.
 */
class SystemTestSpec extends Specification {
    static final TestEnv ENVIRONMENT = TestEnv.load("Config.groovy")

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

}
