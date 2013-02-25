package scolarite

/**
 *
 * @author franck Silvestre
 */
class ScolariteServiceTest extends GroovyTestCase {

  ScolariteService scolariteService = new ScolariteService()


  void testGetEvaluationById() {
    Evaluation dev1 = scolariteService.getEvaluationById(1)
    assertEquals("Devoir 1", dev1.titre)
    assertEquals(1, dev1.coeff)
    assertEquals(18, dev1.note)
  }

  void testGetEtudiantById() {
    Etudiant pauline = scolariteService.getEtudiantById(1)
    assertEquals("Pauline", pauline.prenom)
    assertEquals("Dupont", pauline.nom)
    assertEquals(4, pauline.evaluations.size())
    println pauline
  }

}
