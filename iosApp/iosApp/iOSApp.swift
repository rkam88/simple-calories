import SwiftUI
import ComposeApp

@main
struct iOSApp: App {

    init() {
        KoinHelper().doInit(appDeclaration: { _ in /* do nothing */ })
    }

	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
