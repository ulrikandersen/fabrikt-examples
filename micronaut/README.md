# Micronaut app with generated controllers and models

This is a [Micronaut](https://micronaut.io/) app with controllers and models generated by [Fabrikt](https://github.com/cjbooms/fabrikt).

## Running the app

To run the app, execute the following command:

```bash
./gradlew run
```

## Call endpoints

### Happy path

#### Get all pets
```
curl -X GET http://localhost:8080/pets
```

#### Create a pet
```
curl -X POST http://localhost:8080/pets -H "Content-Type: application/json" -d '{"id": 444, "name": "Pluto", "tag": "dog"}'
```

#### Get a pet by id
```
curl -X GET http://localhost:8080/pets/444
```

### Error cases

#### Create with failed validation (negative id)
```
curl -X POST http://localhost:8080/pets -H "Content-Type: application/json" -d '{"id": -8888, "name": "Pluto"}'
```

#### Get a pet by id that does not exist
```
curl -X GET http://localhost:8080/pets/999
```

#### Query with a limit too high
```
curl -X GET http://localhost:8080/pets?limit=1000
```