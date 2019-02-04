# Philou-pgo-map

This application is made for Philou with love.

## Prerequisite

1. Git
2. Java
3. Clone this project (type `git clone https://github.com/rg-info/philou-pgo-map.git` in the Git bash)
4. Configure PokemonGo++ application to use this application as worker (`http://you-ip:8080/webhook`)

## Installation

Enter in the cloned project and build the application using the command in the Git bash:

```bash
./mvnw clean package
```

If successfully build, you will have the following message in the console:

```bash
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 10.136 s
[INFO] Finished at: 2019-02-04T20:47:26+01:00
[INFO] ------------------------------------------------------------------------
```

## Usage

In a Git bach console at the root of the project, type the following to run the application:

```bash
./mvnw clean package
```

Once the application started the information retreived from the PokemonGo++ application will be printed in the console.