<h1>CRUD with Spring Data Jpa</h1>
1. Il faut avoir intellij utilimate installé <br>
2. Création du projet spring avec les dépendances suivantes : JPA, H2, Spring Web et Lombok<br>
<img src="assets/1.png"/><br>
<img src="assets/2.png"/><br>
3. Création de l'entité Patient<br>
<img src="assets/3.png"/><br>
4. Configuration de l'unité de persistence H2<br>
<img src="assets/4.png"/><br>
5. Création de l'interface Jpa repository<br>
<img src="assets/5.png"/><br>
6. Tester quelques opérations de gestion de patients<br>
<img src="assets/6.png"/><br>
6.1. Creation<br>
<img src="assets/7.png"/><br>
6.2. Liste des patients<br>
<img src="assets/8.png"/><br>
6.3. Consulter un patient<br>
<img src="assets/8.png"/><br>
6.4. Rechercher des patients<br>
<img src="assets/8.png"/><br>
6.5. Mettre à jour un patient<br>
<img src="assets/9.png"/><br>
6.6. Supprimer un patient<br>
<img src="assets/9.png"/><br>
7. Migration de H2 Database vers MySQL<br>
<img src="assets/10-start.spring.io.png"/><br>
<img src="assets/11-start.spring.io.png"/><br>
<img src="assets/11.2-ajout-dependence.png"/><br>
<img src="assets/12-reload-maven-project.png"/><br>
<img src="assets/13-maj-application.proper.png" alt="">
8. Ajout des tables supplémentaires: Médecin, rendez-vous, consultation, users et roles. <br>
<h3>Modele</h3>
<img src="assets/14-model.png" alt="">
<img src="assets/14.1-model.png" alt="">
<h3>Entities</h3>
8.1. Medecin<br>
<img src="assets/16-Medecin.png" alt="">
8.2. Consultation<br>
<img src="assets/15-Consultation.png" alt="">
8.3. RendezVous<br>
<img src="assets/17-RendezVous.png" alt="">
8.4. StatusRDV<br>
<img src="assets/18-StatusRDV.png" alt="">
<h3>Repositories</h3>
8.5. MedecinRepository<br>
<img src="assets/20-MedecinRepository.png" alt="">
8.6. ConsultationRepository<br>
<img src="assets/19-ConsultationRepository.png" alt="">
8.7. RendezVousRepository<br>
<img src="assets/21-RendezVousRepsitory.png" alt="">
8.8. PatientRepository<br>
<img src="assets/22-patientRepository.png" alt="">