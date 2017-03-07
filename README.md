# .Net vs Java vs Go
Comparing hash map implementations in different platforms

## To run:

1. .Net
```bash
cd net && dotnet restore && dotnet run --configuration release
```

2. Java
```bash
cd java && mvn clean package && java -jar target/benchmarks.jar -f 1
```

3. Go
```bash
cd go && go test -bench .
```
