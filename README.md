TP5:
Part of Android Development - ISMIN 2020

Course followed by students of Mines St Etienne, ISMIN - M2 Computer Science.

[![Mines St Etienne](./logo.png)](https://www.mines-stetienne.fr/)

# TP5: HTTP Requests

## 📝 Goal

The goal is to link the app to a Rest API using [Retrofit](https://square.github.io/retrofit/):

You can either use:
 - your own Book Rest API
 - a generic one accessible on: https://bookshelf-gme.cleverapps.io/books

Preparatory work:
- Copy everything from previous TP (except the README)

First:
- Add retrofit dependencies (see course slides) to `build.gradle`
- Add internet permission in `AndroidManifest`

Then:
- Create a `BookService` interface
- Add a `getAllBooks` function with annotations matching the API
- Create an instance of `retrofit` and instantiate `BookService` with it in `MainActivity`
- Call `getAllBooks` in the `onCreate` function and display the books returned by the server

- Add a `createBook` function with annotations matching the API
- Call `createBook` to post a new book to the server and then display the list of books (including the freshly created one)

Finally:
- Add some Toasts to properly display and handle network errors

## 🚀 Getting Started

 - Start Android Studio
 - Select `Open an existing Android Studio project` and pick this directory

That's it! You can code!




TP4:
Part of Android Development - ISMIN 2020

Course followed by students of Mines St Etienne, ISMIN - M2 Computer Science.

[![Mines St Etienne](./logo.png)](https://www.mines-stetienne.fr/)

# TP4: Fragments

## 📝 Goal

The goal is to refactor the app by introducing Fragments.

Preparatory work:
- Copy everything from previous TP (except the README)

Then:
- Create a `BookListFragment` fragment
- Update its attributes and factory method (the one called `newInstance`) to handle a `ArrayList<Book>`
- Move the `<RecyclerView>` from the layout of `MainActivity` to the one of `BookListFragment`
- Do the same for all RecyclerView related logic

In `MainActivity`:
- Add a `<RelativeLayout>` in the layout
- Add some code to create a `BookListFragment` fragment and display it

Then:
- Create a `CreateBookFragment` fragment, if you generate it you can keep only `onCreateView` function and discard everything else
- Move code and layout from `CreateBookActivity` to `CreateBookFragment`
- Create an interface `BookCreator` with a `onBookCreated(book: Book)`
- Use `onAttach` function to save a reference to the activity 
- Implement `BookCreator` interface in `MainActivity`

## 🚀 Getting Started

 - Start Android Studio
 - Select `Open an existing Android Studio project` and pick this directory

That's it! You can code!

## 🛰 Extra

