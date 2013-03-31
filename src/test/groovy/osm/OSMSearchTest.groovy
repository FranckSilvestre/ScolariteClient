package osm

import groovyx.net.http.ContentType
import groovyx.net.http.HTTPBuilder
import groovyx.net.http.Method

/**
 *
 * @author franck Silvestre
 */
class OSMSearchTest extends GroovyTestCase {

  void testConnectionXMLOpenStreetMap() {
      def status = "success"
      def http = new HTTPBuilder("http://nominatim.openstreetmap.org/")
      http.request(Method.GET, ContentType.XML) {
        uri.path = 'search?q=135+pilkington+avenue,+birmingham&format=xml&polygon=1&addressdetails=1'
        response.success = { resp, searchresults -> println ">>>>> ${searchresults.place.country.text()}"  }
        // handler for any failure status code:
        response.failure = { resp ->
          println "Unexpected error: ${resp.statusLine.statusCode} : ${resp.statusLine.reasonPhrase}"
          status = "failure"
        }
      }
      status
    }

}
