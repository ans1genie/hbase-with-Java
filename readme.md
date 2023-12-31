create hbase container :
` docker run -p 16010:16010 -p 8085:8085 -p 9095:9095  --name=hbase-docker -h hbase-docker -d -v $PWD/data:/data dajobe/hbase`