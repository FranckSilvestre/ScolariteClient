package scolarite

import scolarite.client.ScolariteClient

/**
 *
 * @author franck Silvestre
 */
class ScolariteService {

  ScolariteClient scolariteClient = new ScolariteClient()

  Etudiant getEtudiantById(Integer id) {
    Etudiant etudiant = null
    def json = scolariteClient.getJsonEtudiant(id)
    if (json) {
      etudiant = new Etudiant(
              id: json.id,
              nom: json.nom,
              prenom: json.prenom,
              evaluationIds: json.evaluations*.id
      )
    }
    etudiant
  }

  Evaluation getEvaluationById(Integer id) {
    Evaluation evaluation = null
        def json = scolariteClient.getJsonEvaluation(id)
        if (json) {
          evaluation = new Evaluation(
                  id: json.id,
                  coeff: json.coeff,
                  titre: json.titre,
                  note: json.note,
                  noteMax: json.noteMax
          )
        }
        evaluation
  }

}
