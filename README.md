# MobileChallenge

## Overview

This Android Kotlin project is built using a multi-module Clean Architecture. It utilizes the Apollo GraphQL client to interact with the Rick and Morty API and displays a list of characters. Users can navigate to view detailed information for each character.

## Features

- **Kotlin**: The project is developed using the Kotlin programming language, providing concise and expressive code.
  
- **Apollo GraphQL Client**: Utilizes the Apollo GraphQL client to fetch data from the [Rick and Morty API](https://rickandmortyapi.com/).

- **Clean Multi-Module Architecture**: The project follows a clean multi-module architecture, separating concerns into different modules such as `presentation`, `domain`, and `data`.

- **Character List**: Displays a list of characters retrieved from the Rick and Morty API, showcasing their names and images.

- **Character Detail**: Allows users to navigate to a detailed view for each character, presenting additional information.

## Project Structure

- **`app` Module**: The main Android application module containing the UI components, navigation, and other presentation-related features.

- **`presentation` Module**: Handles the presentation layer, including activities, fragments, and ViewModels.

- **`domain` Module**: Contains the business logic, including use cases, entities, and interfaces for repositories.

- **`data` Module**: Manages data-related tasks, such as repository implementations, data sources, and network-related code.

  ## Screenshots

   ![image](https://github.com/jeseal/MobileChallenge/assets/40834446/0056a760-43e0-49a6-98cb-9dffb2a3ab5a)

  ![image](https://github.com/jeseal/MobileChallenge/assets/40834446/58b8a98a-f273-4aca-9fbe-8f15298000fb)


## Setup

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/your-project.git


