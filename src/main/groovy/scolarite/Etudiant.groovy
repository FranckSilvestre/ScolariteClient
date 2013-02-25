package scolarite

/**
 *
 * @author franck Silvestre
 */
class Etudiant {

  ScolariteService scolariteService = new ScolariteService()

  Integer id
  String nom
  String prenom

  List<Integer> evaluationIds = []

  List<Evaluation> getEvaluations() {
    def res = []
    evaluationIds.each { id ->
      res << scolariteService.getEvaluationById(id)
    }
    res
  }

  String toString() {
    def res = "$prenom ${nom.toUpperCase()}\n"
    evaluations.each {eval ->
      res += eval.toString() << "\n"
    }
    res
  }

}
