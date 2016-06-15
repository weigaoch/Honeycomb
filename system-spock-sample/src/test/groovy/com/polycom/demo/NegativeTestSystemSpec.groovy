package com.polycom.demo

import com.polycom.SystemTestSpec
import com.polycom.sqa.demo.HangupFail
import com.polycom.sqa.demo.MediaSuite
import com.polycom.sqa.demo.PlaceCallFail
import com.polycom.sqa.demo.RpdWin
import spock.lang.Specification


/**
 * Created by wgao on 6/15/2016.
 */
class NegativeTestSystemSpec extends SystemTestSpec {

    MediaSuite mediaSuite = new MediaSuite();
    RpdWin rpdWin = new RpdWin();

    def "MediaSuite cannot hangup call"() {

        when:
        step "Make a call from RpdWin", {
            rpdWin.placeCall(mediaSuite)
        }

        then:
        step "MediaSuite should not be able to hangup the call", {
            shouldFail {
                mediaSuite.hangup()
            }
        }
    }


    def "MediaSuite cannot hangup call and should fail on specific Exception"() {

        when:
        step "Make a call from RpdWin", {
            rpdWin.placeCall(mediaSuite)
        }

        then:
        step "MediaSuite should not be able to hangup the call", {
            shouldFail HangupFail, {
                mediaSuite.hangup()
            }
        }
    }

    def "MediaSuite cannot hangup call and should fail on specific Exception(2)"() {

        when:
        step "Make a call from RpdWin", {
            rpdWin.placeCall(mediaSuite)
        }

        then:
        step "MediaSuite should not be able to hangup the call", {
            shouldFail PlaceCallFail, {
                mediaSuite.hangup()
            }
        }
    }
}