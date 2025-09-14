# SwiftyCompose

Build Composable components in Jetpack Compose using SwiftUI-like syntax!

## Dependency
Add the dependency to your build.gradle. Replace version with what is available [here](https://central.sonatype.com/artifact/io.github.deanalvero/swiftycompose/versions).
```
implementation("io.github.deanalvero:swiftycompose:<version>")
```

If you get a `IllegalArgumentException: source must not be null` compiler error, update the following plugins to at least version `2.2.10`:
- org.jetbrains.kotlin.android
- org.jetbrains.kotlin.plugin.compose

## Usage

Prepend an `!`, `+`, or a `-` before the SwiftUI view name.

```
@Composable
fun ExampleComposable() {
    !HStack {
        +Text(
            text = "Swifty"
        ).background(color = Color.Blue)
            .strikethrough()
            .underline()

        -Text(
            text = "Compose"
        ).bold()
    }.background(color = Color.Red)
}
```

Or, call `()`, `invoke()`, or `build()` at the end the chain call.

```
@Composable
fun ExampleComposable() {
    // TODO: replace, for now this is equivalent to @State private var toggleValue: Bool = false
    val toggleValue = stateBinding(false)
    // TODO: replace, for now this is equivalent to @State private var sliderValue: Double = 0.5
    val sliderValue = stateBinding(0.5f)

    VStack {
        Toggle(
            isOn = toggleValue
        ).background(color = Color.Yellow)
            .invoke()

        Slider(
            value = sliderValue,
            bounds = 0f..2f
        )()
        
        !ProgressView(value = 0.5f)
            .frame(width = Dp.Infinity, height = 10.dp)
    }.background(color = Color.Green)
        .build()
}
```

The choice is yours. I prefer to prepend `!` though.

## Supported Components
- VStack
- HStack
- ZStack
- LazyVStack
- LazyHStack
- LazyVGrid
- LazyHGrid
- Text
- Toggle
- Slider
- ProgressView
- TextField
- Button
- Spacer
- Image
- (more to be added)

## Notes

Enjoy!