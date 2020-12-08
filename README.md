# fakerJsonForCN
 get something fake data

## install
mvn source:jar javadoc:jar install

## add dependency in other project
<dependency>
			<groupId>cn.fakejson</groupId>
			<artifactId>fakejson-maven-plugin</artifactId>
			<version>0.0.1-SNAPSHOT</version>
</dependency>

## use 

### fakeEntityList
```
List<E> fakeEntityList = FakeFromEntity.fakeEntityList(E, size);
```

### fakejsons
```
List<Object> fakejsons = FakeFromEntity.fakejsons(E, 5);
```

### fakeEntity
```
E fakeEntity = FakeFromEntity.fakeEntity(E);
```

### fakeDate
```
Date fakeDate = FakeData.fakeDate();
```

### fakeName(CN)
```
String fakeName = FakeData.fakeName();
```
