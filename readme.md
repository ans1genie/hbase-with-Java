- create hbase container :
` docker run -p 16010:16010 -p 8085:8085 -p 9095:9095  --name=hbase-docker -h hbase-docker -d -v $PWD/data:/data dajobe/hbase`

- check if services are up and running :

http://localhost:16010/master-status
http://localhost:16010/zk.jsp
http://localhost:9095/thrift.jsp
http://localhost:8085/rest.jsp