## Android sample MVVM architecture project using with Dagger 2, Retrofit, Rxjava, Room, Navigation component, Livedata

## Structure

<p align="center">
  <img width="500" height="330" src="https://github.com/umutbayramoglu/mvvm-dagger2-databinding-retrofit-rxjava2/blob/master/screenshots/mvvm2.png?raw=true">
</p>


## Screenshots
<p align="center">
  <img src="https://firebasestorage.googleapis.com/v0/b/notificationdemo-ce3aa.appspot.com/o/1.jpeg?alt=media&token=fac63275-3830-485d-9cce-016e70b0c70b" width="250">
  <img src="https://firebasestorage.googleapis.com/v0/b/notificationdemo-ce3aa.appspot.com/o/2.jpeg?alt=media&token=74f1c493-b0d9-4408-9d03-c40cdaf101fc" width="250">
  <img src="https://firebasestorage.googleapis.com/v0/b/notificationdemo-ce3aa.appspot.com/o/3.jpeg?alt=media&token=4f206c79-8c55-4b07-8e97-9409f5bde0e1" width="250">
  <img src="https://firebasestorage.googleapis.com/v0/b/notificationdemo-ce3aa.appspot.com/o/4.jpeg?alt=media&token=7d548775-8367-4575-8dc8-2a9066699926" width="250">

</p>

#### The app consists of following packages:
1. **data**: It contains all the data accessing and manipulating components.
2. **di**: contains Dagger2 classes -that a fast and lightweight dependency injection framework.
3. **screen**: activity, fragment classes and their corresponding viewmodels.
4. **utils**: utility classes.

#### Libraries:
* [Retrofit](https://square.github.io/retrofit/) handles API integration.
* [RxJava2](https://github.com/ReactiveX/RxJava) for implementing observable pattern.
* [Dagger 2](https://google.github.io/dagger/) provides dependency injection.
* [Glide](https://github.com/bumptech/glide) handles image loading.
* [Gson](https://github.com/google/gson) provides serialisation.
* [Room](https://developer.android.com/jetpack/androidx/releases/room)
* [Navigation Component](https://developer.android.com/guide/navigation)
* [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)
