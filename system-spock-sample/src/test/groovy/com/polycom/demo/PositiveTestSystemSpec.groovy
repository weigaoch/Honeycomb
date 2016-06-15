package com.polycom.demo

import com.polycom.SystemTestSpec
import com.polycom.sqa.demo.EndPoint
import com.polycom.sqa.demo.Hdx
import com.polycom.sqa.demo.MediaSuite
import com.polycom.sqa.demo.RpdWin
import spock.lang.Specification
import spock.lang.Title


/**
 * Created by wgao on 6/15/2016.
 */

@Title("Positive tests")
class PositiveTestSystemSpec extends SystemTestSpec {

    MediaSuite mediaSuite = new MediaSuite();
    RpdWin rpdWin = new RpdWin();

    def "MediaSuite make a call to RpdWin and then check on MediaSuite"() {

        when:
        step "Make a call from MediaSuite", {
            mediaSuite.placeCall(rpdWin)
        }

        then:
        step "Check Media Statistics on MediaSuite", {
            assert mediaSuite.mediaStatistics == "123"
        }

        then:
        step "Hangup the call", {
            rpdWin.hangup()
        }

    }

    def "MediaSuite make a call to RpdWin and then check on RpdWin"() {

        when:
        step "Make a call from MediaSuite", {
            mediaSuite.placeCall(rpdWin)
        }

        then:
        step "Check Media Statistics on MediaSuite", {
            assert rpdWin.mediaStatistics == "123"
        }

        then:
        step "Hangup the call", {
            mediaSuite.hangup()
        }

    }

    def "MediaSuite make a call to RpdWin and then check on RpdWin(2)"() {

        when:
        step "Make a call from MediaSuite", {
            mediaSuite.placeCall(rpdWin)
        }

        then:
        step "Check Media Statistics on MediaSuite", {
            assert rpdWin.mediaStatistics == "456"
        }

        then:
        step "Hangup the call", {
            mediaSuite.hangup()
        }

    }

    def "MediaSuite place a simple call to an EndPoint"(EndPoint endPoint, String mediaStat) {

        when:
        step "Make a call from MediaSuite to EndPoint", {
            mediaSuite.placeCall(endPoint)
        }

        then:
        step "Check media statistics on EndPoint", {
            assert endPoint.getMediaStatistics() == mediaStat
        }

        then:
        step "Hangup the call from EndPoint", {
            endPoint.hangup()
        }

        where:
        endPoint                                  | mediaStat
        new RpdWin()                              | "456"
        new Hdx()                                 | "678"
    }

}