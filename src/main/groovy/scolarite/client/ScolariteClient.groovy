package scolarite.client

import groovyx.net.http.HTTPBuilder
import groovyx.net.http.Method

import static groovyx.net.http.ContentType.JSON

/**
 *
 * @author franck Silvestre
 */
class ScolariteClient {

  /**
   * Affiche tous les étudiants au format brut JSON
   * @return le status "success" ou failure"
   */
  def displayAllEtudiants() {
    def status = "success"
    def http = new HTTPBuilder("http://scolarite.ticetime.cloudbees.net")
    http.request(Method.GET, JSON) {
      uri.path = '/api/v1/etudiants'
      response.success = { resp, json -> println json }
      // handler for any failure status code:
      response.failure = { resp ->
        println "Unexpected error: ${resp.statusLine.statusCode} : ${resp.statusLine.reasonPhrase}"
        status = "failure"
      }
    }
    status
  }

  /**
   * Get a student for a given id
   * @param id
   * @return the json object corresponding to the student
   */
  def getJsonEtudiant(Integer id) {
    def res = null
    def http = new HTTPBuilder("http://scolarite.ticetime.cloudbees.net")
    http.request(Method.GET, JSON) {
      uri.path = "/api/v1/etudiants/${id}"
      response.success = {
        resp, json -> res = json
      }
      // handler for any failure status code:
      response.failure = { resp ->
        println "Unexpected error: ${resp.statusLine.statusCode} : ${resp.statusLine.reasonPhrase}"
      }
    }
    res
  }

  /**
     * Get an evaluation for a given id
     * @param id
     * @return the json object corresponding to the student
     */
    def getJsonEvaluation(Integer id) {
      def res = null
      def http = new HTTPBuilder("http://scolarite.ticetime.cloudbees.net")
      http.request(Method.GET, JSON) {
        uri.path = "/api/v1/evaluations/${id}"
        response.success = {
          resp, json -> res = json
        }
        // handler for any failure status code:
        response.failure = { resp ->
          println "Unexpected error: ${resp.statusLine.statusCode} : ${resp.statusLine.reasonPhrase}"
        }
      }
      res
    }


}
