# Hepsihikaye Android App

This is the native Android application for [Hepsihikaye.net](https://hepsihikaye.net), providing a mobile-optimized experience for accessing stories, articles, poems, and videos from the website.

## Features

- Browse trending, recent, and popular content
- View stories by category
- Read stories with a clean, optimized reading interface
- Watch videos from the video section
- Like/dislike posts
- Add comments to posts
- Offline reading support for saved stories

## Technologies Used

- Kotlin programming language
- MVVM architecture with LiveData and ViewModel
- Retrofit for network operations
- Glide for image loading
- Coroutines for asynchronous operations
- Material Design components for UI

## Screenshots

[Screenshots will be added here]

## Requirements

- Android 6.0 (Marshmallow) or higher (API Level 23+)
- Internet connection for online features

## Building the Project

1. Clone the repository:
```
git clone https://github.com/elnidal/apphikayeandorid.git
```

2. Open the project in Android Studio.

3. Sync Gradle and build the project.

4. Run on an emulator or connected device.

## API Integration

The app integrates with the Hepsihikaye.net API to fetch content. The API endpoints used are:

- `/api/home` - Get homepage data
- `/api/category/{category}` - Get posts by category
- `/api/post/{id}` - Get post details
- `/api/videos` - Get video listings

## Project Structure

- `api` - Network operations and API interfaces
- `model` - Data classes
- `ui` - Activities, fragments, and view-related components
- `util` - Utility classes and helper functions

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Contact

For any inquiries, please reach out to [contact information]. 