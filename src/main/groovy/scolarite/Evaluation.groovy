package scolarite

/**
 *
 * @author franck Silvestre
 */
class Evaluation {
  Integer id
  String titre
  Float coeff
  Float note
  Float noteMax

  String toString() {
    "$titre : $note / $noteMax (coeff $coeff)"
  }
}
