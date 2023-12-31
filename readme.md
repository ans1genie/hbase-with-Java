#### package the project into a jar : `mvn clean compile assembly:single`

#### create hbase container :

cmd: ` docker run -p 2181:2181  -p 60000:60000  -p 60010:60010  -p 60020:60020  -p 60030:60030  -p 8080:8080  -p 8085:8085  -p 9090:9090  -p 9095:9095  --name=hbase-docker -h hbase-docker -d -v $PWD/data:/data dajobe/hbase`

#### check if services are up and running :

http://localhost:16010/master-status

http://localhost:16010/zk.jsp

http://localhost:9095/thrift.jsp

http://localhost:8085/rest.jsp

#### testing hbase inside the container:
  run hbase shell : `docker exec -it hbase-docker /opt/hbase/bin/hbase shell`

  create a table: `create 'commande' , 'clients', 'produits'`

  insert some data for testing into the hbase after logging
  
-- row1

  `put 'commande', 'row1', 'clients:First_Name', 'oumaima'`

  `put 'commande', 'row1', 'clients:Second_Name', 'AB'`

  `put 'commande', 'row1', 'produits:Fileire', 'IAAdD'`

  `put 'commande', 'row1', 'produits:Annee_Bac', '2018'`

-- row2

  `put 'commande', 'row2', 'clients:First_Name', 'Anas'`

  `put 'commande', 'row2', 'clients:Second_Name', 'ABA`'

  `put 'commande', 'row2', 'produits:Fileire', 'GLSID'`

  `put 'commande', 'row2', 'produits:Annee_Bac', '2013'`

#### insert data with this project into hbase 
- step 1: build the project jar: `mvn clean compile assembly:single` 
- step 2: copy the jar from(`target/hbase-testing-1.0-SNAPSHOT-jar-with-dependencies.jar`) into the mapped volume folder `data`
- step 3: connect into the container shell with `docker exec -it hbase-docker sh` 
- step 4: run the jar with this command : `java -jar /data/hbase-testing-1.0-SNAPSHOT-jar-with-dependencies.jar`