# .Net vs Java vs Go
Comparing hash map implementations in different platforms

## To run:

### .Net
```bash
cd net && dotnet restore && dotnet run --configuration release
```

### Java
```bash
cd java && mvn clean package && java -jar target/benchmarks.jar -f 1
```

### Go
```bash
cd go && go test -bench .
```
