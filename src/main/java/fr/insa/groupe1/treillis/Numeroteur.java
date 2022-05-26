//package fr.insa.groupe1.treillis;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.UUID;
//
//public class Numeroteur<TO> {
//
//   private Map<UUID, TO> idVersObjet;
//   private Map<TO, UUID> objetVersId;
//   private UUID prochainID
//
//   private Numeroteur(UUID prochainID) {
//      this.idVersObjet = new HashMap<>();
//      this.objetVersId = new HashMap<>();
//      this.prochainID = prochainID;
//
//   }
//   public void creeID(TO obj) {
//      this.idVersObjet.put(this.prochainID, obj);
//      this.objetVersId.put(obj, this.prochainID);
//
//   }
//
//}
