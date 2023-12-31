#### create hbase container :
cmd: ` docker run -p 16010:16010 -p 8085:8085 -p 9095:9095  --name=hbase-docker -h hbase-docker -d -v $PWD/data:/data dajobe/hbase`

#### check if services are up and running :

http://localhost:16010/master-status

http://localhost:16010/zk.jsp

http://localhost:9095/thrift.jsp

http://localhost:8085/rest.jsp

#### testing hbase inside the container:
  run hbase shell : `docker exec -it hbase-docker /opt/hbase/bin/hbase shell
  insert some data for testing into the hbase after logging`
  
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
  