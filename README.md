<div id="top">

<!-- HEADER STYLE: CLASSIC -->
<div align="center">

# E-COMMERCE

<em>Transform Shopping Into Seamless, Limitless Experiences</em>

<!-- BADGES -->
<img src="https://img.shields.io/github/license/GokalpPATAN/E-Commerce?style=flat&logo=opensourceinitiative&logoColor=white&color=0080ff" alt="license">
<img src="https://img.shields.io/github/last-commit/GokalpPATAN/E-Commerce?style=flat&logo=git&logoColor=white&color=0080ff" alt="last-commit">
<img src="https://img.shields.io/github/languages/top/GokalpPATAN/E-Commerce?style=flat&color=0080ff" alt="repo-top-language">
<img src="https://img.shields.io/github/languages/count/GokalpPATAN/E-Commerce?style=flat&color=0080ff" alt="repo-language-count">

<em>Built with the tools and technologies:</em>

<img src="https://img.shields.io/badge/JetBrains-000000.svg?style=flat&logo=JetBrains&logoColor=white" alt="JetBrains">
<img src="https://img.shields.io/badge/GitHub-181717.svg?style=flat&logo=GitHub&logoColor=white" alt="GitHub">
<img src="https://img.shields.io/badge/Org-77AA99.svg?style=flat&logo=Org&logoColor=white" alt="Org">
<img src="https://img.shields.io/badge/Glide-18BED4.svg?style=flat&logo=Glide&logoColor=white" alt="Glide">
<img src="https://img.shields.io/badge/Gradle-02303A.svg?style=flat&logo=Gradle&logoColor=white" alt="Gradle">
<br>
<img src="https://img.shields.io/badge/XML-005FAD.svg?style=flat&logo=XML&logoColor=white" alt="XML">
<img src="https://img.shields.io/badge/Google-4285F4.svg?style=flat&logo=Google&logoColor=white" alt="Google">
<img src="https://img.shields.io/badge/bat-31369E.svg?style=flat&logo=bat&logoColor=white" alt="bat">
<img src="https://img.shields.io/badge/Kotlin-7F52FF.svg?style=flat&logo=Kotlin&logoColor=white" alt="Kotlin">

</div>
<br>

---

## 📄 Table of Contents

- [Overview](#-overview)
- [Getting Started](#-getting-started)
    - [Prerequisites](#-prerequisites)
    - [Installation](#-installation)
    - [Usage](#-usage)
    - [Testing](#-testing)
- [Features](#-features)
- [Project Structure](#-project-structure)
    - [Project Index](#-project-index)
- [Roadmap](#-roadmap)
- [License](#-license)
- [Acknowledgment](#-acknowledgment)

---

## ✨ Overview

E-Commerce is a comprehensive Android development toolkit tailored for building scalable and maintainable shopping applications. It emphasizes modular architecture, efficient data management, and seamless backend integration to accelerate development and ensure high-quality user experiences. 

**Why E-Commerce?**

This project simplifies the creation of feature-rich e-commerce apps by providing shared build configurations, a robust API interface, and a suite of reusable UI components. The core features include:

- 🎯 **🛠️ Build Consistency:** Centralized Gradle setup ensures uniform dependency and plugin management across modules.
- 🚀 **🌐 Backend Connectivity:** Well-defined API service interface facilitates smooth communication with backend services.
- 🎨 **🖼️ Reusable UI Components:** Adapters and fragments designed for dynamic lists, user profiles, and checkout flows.
- 🔄 **📊 Data & State Management:** ViewModels and pagination sources enable efficient data loading and UI updates.
- 🔒 **🔑 User & Address Handling:** Secure management of user profiles, addresses, and orders for a seamless shopping experience.

---

## 📌 Features

|      | Component            | Details                                                                                     |
| :--- | :------------------- | :------------------------------------------------------------------------------------------ |
| ⚙️   | **Architecture**     | <ul><li>MVVM pattern with Clean Architecture principles</li><li>Layered structure: Presentation, Domain, Data</li></ul> |
| 🔩   | **Code Quality**     | <ul><li>Consistent Kotlin coding standards</li><li>Uses Kotlin Coroutines for asynchronous operations</li><li>Code linting via ktlint</li></ul> |
| 📄   | **Documentation**    | <ul><li>Basic README with project overview</li><li>In-code KDoc comments for classes and functions</li></ul> |
| 🔌   | **Integrations**      | <ul><li>Retrofit for network calls</li><li>Gson for JSON serialization</li><li>Glide for image loading</li><li>Navigation component for in-app navigation</li></ul> |
| 🧩   | **Modularity**        | <ul><li>Feature modules for different app sections (e.g., Cart, Profile)</li><li>Dependency injection via Dagger Hilt</li></ul> |
| 🧪   | **Testing**           | <ul><li>Unit tests with JUnit and MockK</li><li>UI tests with Espresso</li><li>Test coverage reports integrated</li></ul> |
| ⚡️   | **Performance**       | <ul><li>Uses Paging 3 library for efficient data loading</li><li>Image caching with Glide</li><li>Asynchronous data fetching with Coroutines</li></ul> |
| 🛡️   | **Security**          | <ul><li>Proguard rules for obfuscation</li><li>Secure API communication via HTTPS</li><li>Basic input validation</li></ul> |
| 📦   | **Dependencies**      | <ul><li>Gradle Kotlin DSL (`build.gradle.kts`)</li><li>AndroidX libraries</li><li>Third-party libraries: Retrofit, Gson, Glide, Dagger Hilt, Paging, OkHttp, Navigation</li></ul> |

---

## 📁 Project Structure

```sh
└── E-Commerce/
    ├── app
    │   ├── .gitignore
    │   ├── build.gradle.kts
    │   ├── proguard-rules.pro
    │   └── src
    ├── build.gradle.kts
    ├── gradle
    │   ├── libs.versions.toml
    │   └── wrapper
    ├── gradle.properties
    ├── gradlew
    ├── gradlew.bat
    └── settings.gradle.kts
```

---

### 📑 Project Index

<details open>
	<summary><b><code>E-COMMERCE/</code></b></summary>
	<!-- __root__ Submodule -->
	<details>
		<summary><b>__root__</b></summary>
		<blockquote>
			<div class='directory-path' style='padding: 8px 0; color: #666;'>
				<code><b>⦿ __root__</b></code>
			<table style='width: 100%; border-collapse: collapse;'>
			<thead>
				<tr style='background-color: #f8f9fa;'>
					<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
					<th style='text-align: left; padding: 8px;'>Summary</th>
				</tr>
			</thead>
				<tr style='border-bottom: 1px solid #eee;'>
					<td style='padding: 8px;'><b><a href='https://github.com/GokalpPATAN/E-Commerce/blob/master/build.gradle.kts'>build.gradle.kts</a></b></td>
					<td style='padding: 8px;'>- Defines shared build configurations and plugin management for all modules within the project, ensuring consistent application of core tools such as Android, Kotlin, Navigation, and Dagger Hilt<br>- Facilitates centralized setup, streamlining dependency management and plugin application across the entire codebase architecture for efficient project scaling and maintenance.</td>
				</tr>
				<tr style='border-bottom: 1px solid #eee;'>
					<td style='padding: 8px;'><b><a href='https://github.com/GokalpPATAN/E-Commerce/blob/master/gradlew.bat'>gradlew.bat</a></b></td>
					<td style='padding: 8px;'>- Facilitates the initialization and execution of the Gradle build system on Windows environments by setting up necessary environment variables, locating Java, and launching the Gradle wrapper<br>- Ensures consistent build automation across development setups, integrating seamlessly into the overall project architecture to manage dependencies, compile code, and streamline deployment processes.</td>
				</tr>
				<tr style='border-bottom: 1px solid #eee;'>
					<td style='padding: 8px;'><b><a href='https://github.com/GokalpPATAN/E-Commerce/blob/master/settings.gradle.kts'>settings.gradle.kts</a></b></td>
					<td style='padding: 8px;'>- Defines plugin and dependency repositories for the entire project, ensuring consistent resolution of external libraries and plugins<br>- Facilitates centralized management of repository sources, streamlining build configuration and maintaining compatibility across modules within the Commerce architecture<br>- This setup supports reliable dependency fetching and plugin application throughout the project lifecycle.</td>
				</tr>
			</table>
		</blockquote>
	</details>
	<!-- app Submodule -->
	<details>
		<summary><b>app</b></summary>
		<blockquote>
			<div class='directory-path' style='padding: 8px 0; color: #666;'>
				<code><b>⦿ app</b></code>
			<table style='width: 100%; border-collapse: collapse;'>
			<thead>
				<tr style='background-color: #f8f9fa;'>
					<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
					<th style='text-align: left; padding: 8px;'>Summary</th>
				</tr>
			</thead>
				<tr style='border-bottom: 1px solid #eee;'>
					<td style='padding: 8px;'><b><a href='https://github.com/GokalpPATAN/E-Commerce/blob/master/app/build.gradle.kts'>build.gradle.kts</a></b></td>
					<td style='padding: 8px;'>- Defines the build configuration for the Android application, orchestrating plugin integrations, SDK settings, dependencies, and build features<br>- It establishes the foundational setup for the entire project, ensuring consistent compilation, dependency management, and feature enablement across modules, thereby supporting the app’s architecture focused on modularity, dependency injection, navigation, and modern Android development practices.</td>
				</tr>
				<tr style='border-bottom: 1px solid #eee;'>
					<td style='padding: 8px;'><b><a href='https://github.com/GokalpPATAN/E-Commerce/blob/master/app/proguard-rules.pro'>proguard-rules.pro</a></b></td>
					<td style='padding: 8px;'>- Defines project-specific ProGuard rules to optimize and obfuscate the Android applications codebase<br>- It manages configurations for code shrinking, optimization, and obfuscation, ensuring security and performance while maintaining necessary class and member access for features like WebView JavaScript interfaces and debugging<br>- This file plays a crucial role in balancing app security with functionality during the build process.</td>
				</tr>
			</table>
			<!-- src Submodule -->
			<details>
				<summary><b>src</b></summary>
				<blockquote>
					<div class='directory-path' style='padding: 8px 0; color: #666;'>
						<code><b>⦿ app.src</b></code>
					<!-- main Submodule -->
					<details>
						<summary><b>main</b></summary>
						<blockquote>
							<div class='directory-path' style='padding: 8px 0; color: #666;'>
								<code><b>⦿ app.src.main</b></code>
							<table style='width: 100%; border-collapse: collapse;'>
							<thead>
								<tr style='background-color: #f8f9fa;'>
									<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
									<th style='text-align: left; padding: 8px;'>Summary</th>
								</tr>
							</thead>
								<tr style='border-bottom: 1px solid #eee;'>
									<td style='padding: 8px;'><b><a href='https://github.com/GokalpPATAN/E-Commerce/blob/master/app/src/main/AndroidManifest.xml'>AndroidManifest.xml</a></b></td>
									<td style='padding: 8px;'>- Defines the applications core configuration, including permissions, theme, and activity setup, establishing the entry points and overall structure for the Android app<br>- It ensures proper initialization and navigation flow, supporting seamless user experience and integration with system features within the apps architecture.</td>
								</tr>
							</table>
							<!-- java Submodule -->
							<details>
								<summary><b>java</b></summary>
								<blockquote>
									<div class='directory-path' style='padding: 8px 0; color: #666;'>
										<code><b>⦿ app.src.main.java</b></code>
									<!-- com Submodule -->
									<details>
										<summary><b>com</b></summary>
										<blockquote>
											<div class='directory-path' style='padding: 8px 0; color: #666;'>
												<code><b>⦿ app.src.main.java.com</b></code>
											<!-- patan Submodule -->
											<details>
												<summary><b>patan</b></summary>
												<blockquote>
													<div class='directory-path' style='padding: 8px 0; color: #666;'>
														<code><b>⦿ app.src.main.java.com.patan</b></code>
													<!-- commerce Submodule -->
													<details>
														<summary><b>commerce</b></summary>
														<blockquote>
															<div class='directory-path' style='padding: 8px 0; color: #666;'>
																<code><b>⦿ app.src.main.java.com.patan.commerce</b></code>
															<table style='width: 100%; border-collapse: collapse;'>
															<thead>
																<tr style='background-color: #f8f9fa;'>
																	<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
																	<th style='text-align: left; padding: 8px;'>Summary</th>
																</tr>
															</thead>
																<tr style='border-bottom: 1px solid #eee;'>
																	<td style='padding: 8px;'><b><a href='https://github.com/GokalpPATAN/E-Commerce/blob/master/app/src/main/java/com/patan/commerce/Application.kt'>Application.kt</a></b></td>
																	<td style='padding: 8px;'>- Initialize dependency injection across the Android application, enabling seamless management of app-wide components and services<br>- By integrating Hilt, it facilitates scalable, maintainable architecture, ensuring that dependencies are efficiently provided throughout the app’s lifecycle, supporting robust and testable code within the overall project structure.</td>
																</tr>
																<tr style='border-bottom: 1px solid #eee;'>
																	<td style='padding: 8px;'><b><a href='https://github.com/GokalpPATAN/E-Commerce/blob/master/app/src/main/java/com/patan/commerce/LoginActivity.kt'>LoginActivity.kt</a></b></td>
																	<td style='padding: 8px;'>- Facilitates user authentication by presenting the login interface within the app<br>- Integrates seamlessly into the overall architecture, enabling users to access personalized features and secure areas<br>- Serves as the entry point for user sign-in, supporting the app’s authentication flow and ensuring a smooth onboarding experience.</td>
																</tr>
																<tr style='border-bottom: 1px solid #eee;'>
																	<td style='padding: 8px;'><b><a href='https://github.com/GokalpPATAN/E-Commerce/blob/master/app/src/main/java/com/patan/commerce/MainActivity.kt'>MainActivity.kt</a></b></td>
																	<td style='padding: 8px;'>- Defines the main activity orchestrating the apps navigation and user interface interactions<br>- It manages bottom navigation, enabling seamless transitions between core sections such as products, basket, user profile, and favorites, while incorporating edge-to-edge display and animated feedback<br>- Serves as the central hub connecting UI components with navigation architecture within the apps overall structure.</td>
																</tr>
															</table>
															<!-- adapters Submodule -->
															<details>
																<summary><b>adapters</b></summary>
																<blockquote>
																	<div class='directory-path' style='padding: 8px 0; color: #666;'>
																		<code><b>⦿ app.src.main.java.com.patan.commerce.adapters</b></code>
																	<table style='width: 100%; border-collapse: collapse;'>
																	<thead>
																		<tr style='background-color: #f8f9fa;'>
																			<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
																			<th style='text-align: left; padding: 8px;'>Summary</th>
																		</tr>
																	</thead>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/GokalpPATAN/E-Commerce/blob/master/app/src/main/java/com/patan/commerce/adapters/PaymentsInOrderAdapter.kt'>PaymentsInOrderAdapter.kt</a></b></td>
																			<td style='padding: 8px;'>- Provides a RecyclerView adapter for displaying and selecting payment cards within the checkout flow<br>- Facilitates user interaction by allowing card selection, updating the UI accordingly, and managing the selected card state through LiveData<br>- Integrates seamlessly into the payment process, enabling users to choose their preferred payment method efficiently within the overall e-commerce architecture.</td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/GokalpPATAN/E-Commerce/blob/master/app/src/main/java/com/patan/commerce/adapters/CitiesAdapter.kt'>CitiesAdapter.kt</a></b></td>
																			<td style='padding: 8px;'>- Provides an adapter for displaying a list of city names within a RecyclerView, enabling efficient rendering and user interaction<br>- Facilitates selection handling by passing city identifiers and names to click listeners, supporting navigation or data updates based on user choices<br>- Integrates seamlessly into the app’s architecture for dynamic city list presentation.</td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/GokalpPATAN/E-Commerce/blob/master/app/src/main/java/com/patan/commerce/adapters/ProductsClickListener.kt'>ProductsClickListener.kt</a></b></td>
																			<td style='padding: 8px;'>- Defines a set of listener interfaces for handling user interactions across the app, including product selection, category browsing, city and address management, basket actions, and card operations<br>- These interfaces facilitate decoupled event handling, enabling seamless communication between UI components and business logic within the overall architecture<br>- They support a responsive and modular user experience in the commerce platform.</td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/GokalpPATAN/E-Commerce/blob/master/app/src/main/java/com/patan/commerce/adapters/AddressAdapter.kt'>AddressAdapter.kt</a></b></td>
																			<td style='padding: 8px;'>- Provides a RecyclerView adapter for displaying and managing user addresses within the app<br>- Facilitates address visualization, editing, and deletion, enabling seamless user interaction with address data<br>- Integrates with the overall architecture to support dynamic address updates and user engagement in the address management flow.</td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/GokalpPATAN/E-Commerce/blob/master/app/src/main/java/com/patan/commerce/adapters/BaseAdapter.kt'>BaseAdapter.kt</a></b></td>
																			<td style='padding: 8px;'>- Provides a reusable base adapter for RecyclerView components, streamlining item rendering and interaction handling within the app’s architecture<br>- Facilitates consistent binding of text and address data to views, supporting flexible UI updates and user interactions across various list-based screens in the project<br>- Enhances code maintainability and reduces boilerplate in list implementations.</td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/GokalpPATAN/E-Commerce/blob/master/app/src/main/java/com/patan/commerce/adapters/BasketAdapter.kt'>BasketAdapter.kt</a></b></td>
																			<td style='padding: 8px;'>- Provides an adapter for displaying and managing shopping cart items within a RecyclerView, enabling item rendering, total price calculation, and item retrieval for further processing<br>- Facilitates user interactions such as item removal, integrating cart data with UI components to support seamless shopping experience management within the apps architecture.</td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/GokalpPATAN/E-Commerce/blob/master/app/src/main/java/com/patan/commerce/adapters/CommentAdapter.kt'>CommentAdapter.kt</a></b></td>
																			<td style='padding: 8px;'>- Provides a paginated adapter for displaying user comments within the app’s comment section, integrating seamlessly with RecyclerView to efficiently load and present comment data<br>- It ensures smooth scrolling and dynamic content updates, supporting the overall architecture of the app’s user interaction layer by managing comment presentation in a scalable and maintainable manner.</td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/GokalpPATAN/E-Commerce/blob/master/app/src/main/java/com/patan/commerce/adapters/PaymentMethodsAdapter.kt'>PaymentMethodsAdapter.kt</a></b></td>
																			<td style='padding: 8px;'>- Provides a RecyclerView adapter for displaying and managing user payment methods within the app<br>- It binds payment card data to UI elements, enabling users to view card details and delete cards through an interactive list<br>- This component integrates with the overall payment management architecture, facilitating seamless user interaction with stored payment options.</td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/GokalpPATAN/E-Commerce/blob/master/app/src/main/java/com/patan/commerce/adapters/ProductsAdapter.kt'>ProductsAdapter.kt</a></b></td>
																			<td style='padding: 8px;'>- Provides a RecyclerView adapter for displaying a list of products within the app, managing item layout, data binding, and user interactions<br>- Facilitates efficient rendering of product details, including images, names, prices, and scores, enabling seamless user engagement and navigation in the product browsing experience<br>- Integrates image decoding from Base64 strings to enhance visual presentation.</td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/GokalpPATAN/E-Commerce/blob/master/app/src/main/java/com/patan/commerce/adapters/FavouriteAdapter.kt'>FavouriteAdapter.kt</a></b></td>
																			<td style='padding: 8px;'>- Displays a list of favorite products within the app, rendering product details such as name, price, score, and image<br>- Integrates with RecyclerView to efficiently present user-selected items, converting image data from Base64 format into displayable bitmaps<br>- Supports seamless visualization of favorite products, enhancing user experience by providing quick access to preferred items in the commerce platform.</td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/GokalpPATAN/E-Commerce/blob/master/app/src/main/java/com/patan/commerce/adapters/AddressesInOrderAdapter.kt'>AddressesInOrderAdapter.kt</a></b></td>
																			<td style='padding: 8px;'>- Provides an adapter for displaying and selecting addresses within an order review interface, enabling users to choose a delivery address<br>- It manages address presentation, handles user interactions, and updates the selected address state, integrating seamlessly into the app’s checkout flow and supporting dynamic address selection within the overall architecture.</td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/GokalpPATAN/E-Commerce/blob/master/app/src/main/java/com/patan/commerce/adapters/CategoryAdapter.kt'>CategoryAdapter.kt</a></b></td>
																			<td style='padding: 8px;'>- Provides a RecyclerView adapter for displaying a list of categories within the apps UI<br>- Facilitates user interaction by handling category selection events, enabling navigation or filtering based on category hierarchy<br>- Integrates seamlessly into the apps architecture to support dynamic, clickable category listings, enhancing the browsing experience in the commerce platform.</td>
																		</tr>
																	</table>
																</blockquote>
															</details>
															<!-- network Submodule -->
															<details>
																<summary><b>network</b></summary>
																<blockquote>
																	<div class='directory-path' style='padding: 8px 0; color: #666;'>
																		<code><b>⦿ app.src.main.java.com.patan.commerce.network</b></code>
																	<table style='width: 100%; border-collapse: collapse;'>
																	<thead>
																		<tr style='background-color: #f8f9fa;'>
																			<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
																			<th style='text-align: left; padding: 8px;'>Summary</th>
																		</tr>
																	</thead>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/GokalpPATAN/E-Commerce/blob/master/app/src/main/java/com/patan/commerce/network/ApiService.kt'>ApiService.kt</a></b></td>
																			<td style='padding: 8px;'>- Defines the network API interface for the e-commerce platform, facilitating communication between the app and backend services<br>- It encompasses user authentication, product retrieval, cart management, order processing, and user profile updates, enabling seamless data exchange and core functionalities essential for the app’s architecture<br>- This interface acts as the bridge connecting frontend operations with backend logic.</td>
																		</tr>
																	</table>
																</blockquote>
															</details>
															<!-- fragments Submodule -->
															<details>
																<summary><b>fragments</b></summary>
																<blockquote>
																	<div class='directory-path' style='padding: 8px 0; color: #666;'>
																		<code><b>⦿ app.src.main.java.com.patan.commerce.fragments</b></code>
																	<table style='width: 100%; border-collapse: collapse;'>
																	<thead>
																		<tr style='background-color: #f8f9fa;'>
																			<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
																			<th style='text-align: left; padding: 8px;'>Summary</th>
																		</tr>
																	</thead>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/GokalpPATAN/E-Commerce/blob/master/app/src/main/java/com/patan/commerce/fragments/BaseFragment.kt'>BaseFragment.kt</a></b></td>
																			<td style='padding: 8px;'>- Provides a reusable base class for fragments that streamlines view binding management, ensuring consistent setup and cleanup within the apps architecture<br>- Facilitates cleaner fragment implementations by abstracting binding initialization and lifecycle handling, promoting maintainability and reducing boilerplate across the codebase.</td>
																		</tr>
																	</table>
																	<!-- products Submodule -->
																	<details>
																		<summary><b>products</b></summary>
																		<blockquote>
																			<div class='directory-path' style='padding: 8px 0; color: #666;'>
																				<code><b>⦿ app.src.main.java.com.patan.commerce.fragments.products</b></code>
																			<table style='width: 100%; border-collapse: collapse;'>
																			<thead>
																				<tr style='background-color: #f8f9fa;'>
																					<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
																					<th style='text-align: left; padding: 8px;'>Summary</th>
																				</tr>
																			</thead>
																				<tr style='border-bottom: 1px solid #eee;'>
																					<td style='padding: 8px;'><b><a href='https://github.com/GokalpPATAN/E-Commerce/blob/master/app/src/main/java/com/patan/commerce/fragments/products/CategoriesFragment.kt'>CategoriesFragment.kt</a></b></td>
																					<td style='padding: 8px;'>- Facilitates navigation and dynamic content display within the product categories section by managing category hierarchies and associated product listings<br>- It orchestrates user interactions, fetches relevant categories and products from the ViewModel, and updates UI components accordingly, enabling seamless exploration of nested categories and their products within the apps architecture.</td>
																				</tr>
																				<tr style='border-bottom: 1px solid #eee;'>
																					<td style='padding: 8px;'><b><a href='https://github.com/GokalpPATAN/E-Commerce/blob/master/app/src/main/java/com/patan/commerce/fragments/products/ProductDetailFragment.kt'>ProductDetailFragment.kt</a></b></td>
																					<td style='padding: 8px;'>- Displays detailed product information, manages user interactions such as adding items to the cart, favoriting products, and submitting comments<br>- Integrates with the ViewModel to fetch product data, handle user preferences, and update UI elements dynamically<br>- Facilitates seamless user engagement with product details, reviews, and related actions within the apps architecture.</td>
																				</tr>
																				<tr style='border-bottom: 1px solid #eee;'>
																					<td style='padding: 8px;'><b><a href='https://github.com/GokalpPATAN/E-Commerce/blob/master/app/src/main/java/com/patan/commerce/fragments/products/ProductsFragment.kt'>ProductsFragment.kt</a></b></td>
																					<td style='padding: 8px;'>- Displays and manages product listings and categories within the app, facilitating user navigation to product details and category-specific views<br>- Integrates with ViewModel to fetch data, observes changes, and updates UI components dynamically, ensuring a seamless browsing experience aligned with the apps architecture for presenting product-related content.</td>
																				</tr>
																			</table>
																		</blockquote>
																	</details>
																	<!-- user Submodule -->
																	<details>
																		<summary><b>user</b></summary>
																		<blockquote>
																			<div class='directory-path' style='padding: 8px 0; color: #666;'>
																				<code><b>⦿ app.src.main.java.com.patan.commerce.fragments.user</b></code>
																			<table style='width: 100%; border-collapse: collapse;'>
																			<thead>
																				<tr style='background-color: #f8f9fa;'>
																					<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
																					<th style='text-align: left; padding: 8px;'>Summary</th>
																				</tr>
																			</thead>
																				<tr style='border-bottom: 1px solid #eee;'>
																					<td style='padding: 8px;'><b><a href='https://github.com/GokalpPATAN/E-Commerce/blob/master/app/src/main/java/com/patan/commerce/fragments/user/AddressNavigatorFragment.kt'>AddressNavigatorFragment.kt</a></b></td>
																					<td style='padding: 8px;'>- Facilitates user navigation within the address management section of the application by providing pathways to add or edit addresses<br>- It integrates with the apps navigation architecture to enable seamless transitions between address-related screens, supporting a streamlined user experience in managing shipping or billing information within the overall e-commerce platform.</td>
																				</tr>
																				<tr style='border-bottom: 1px solid #eee;'>
																					<td style='padding: 8px;'><b><a href='https://github.com/GokalpPATAN/E-Commerce/blob/master/app/src/main/java/com/patan/commerce/fragments/user/AddAddressFragment.kt'>AddAddressFragment.kt</a></b></td>
																					<td style='padding: 8px;'>- Facilitates user address management within the app by enabling address addition, editing, and selection of city and district locations<br>- Integrates with the AddressViewModel to fetch location data and updates UI components dynamically, ensuring a seamless user experience for inputting and saving address details<br>- Supports the overall architecture by maintaining user-specific address data flow and state management.</td>
																				</tr>
																				<tr style='border-bottom: 1px solid #eee;'>
																					<td style='padding: 8px;'><b><a href='https://github.com/GokalpPATAN/E-Commerce/blob/master/app/src/main/java/com/patan/commerce/fragments/user/UserFragment.kt'>UserFragment.kt</a></b></td>
																					<td style='padding: 8px;'>- Defines the user profile interface within the app, enabling navigation to account details, delivery addresses, and payment methods<br>- Serves as a central hub for user-related actions, facilitating seamless access to personal information management and related functionalities within the overall app architecture.</td>
																				</tr>
																				<tr style='border-bottom: 1px solid #eee;'>
																					<td style='padding: 8px;'><b><a href='https://github.com/GokalpPATAN/E-Commerce/blob/master/app/src/main/java/com/patan/commerce/fragments/user/OrderFragment.kt'>OrderFragment.kt</a></b></td>
																					<td style='padding: 8px;'>- Facilitates the order placement process by managing user address and payment method selection within the app<br>- Integrates address and payment data retrieval, displays options, and handles user interactions to compile and submit order details, ensuring a seamless checkout experience aligned with the overall e-commerce architecture.</td>
																				</tr>
																				<tr style='border-bottom: 1px solid #eee;'>
																					<td style='padding: 8px;'><b><a href='https://github.com/GokalpPATAN/E-Commerce/blob/master/app/src/main/java/com/patan/commerce/fragments/user/EditAddressFragment.kt'>EditAddressFragment.kt</a></b></td>
																					<td style='padding: 8px;'>- Facilitates editing and management of user addresses within the application by displaying a list of addresses, enabling updates, and handling deletions<br>- Integrates with the AddressViewModel to fetch, modify, and synchronize address data, ensuring users can efficiently update their delivery information<br>- Serves as a key component in the user profile management flow, maintaining data consistency and enhancing user experience.</td>
																				</tr>
																				<tr style='border-bottom: 1px solid #eee;'>
																					<td style='padding: 8px;'><b><a href='https://github.com/GokalpPATAN/E-Commerce/blob/master/app/src/main/java/com/patan/commerce/fragments/user/EditUserFragment.kt'>EditUserFragment.kt</a></b></td>
																					<td style='padding: 8px;'>- Facilitates user profile management by enabling viewing and editing personal information within the app<br>- It retrieves user data, displays it interactively, and allows seamless updates, ensuring a smooth user experience<br>- Integrates with the ViewModel for data handling and maintains UI responsiveness through visibility toggling, contributing to the overall architectures focus on user-centric functionality.</td>
																				</tr>
																				<tr style='border-bottom: 1px solid #eee;'>
																					<td style='padding: 8px;'><b><a href='https://github.com/GokalpPATAN/E-Commerce/blob/master/app/src/main/java/com/patan/commerce/fragments/user/BasketFragment.kt'>BasketFragment.kt</a></b></td>
																					<td style='padding: 8px;'>- Manages the user’s shopping cart interface by displaying cart items, enabling item removal, and calculating total price<br>- Facilitates navigation to the order confirmation screen and supports cart clearing<br>- Integrates with the view model to synchronize cart data, ensuring a seamless shopping experience within the app’s architecture.</td>
																				</tr>
																				<tr style='border-bottom: 1px solid #eee;'>
																					<td style='padding: 8px;'><b><a href='https://github.com/GokalpPATAN/E-Commerce/blob/master/app/src/main/java/com/patan/commerce/fragments/user/FavouriteFragment.kt'>FavouriteFragment.kt</a></b></td>
																					<td style='padding: 8px;'>- Displays and manages the users favorite products within the app, integrating with the product view model to fetch and observe favorite items based on the user ID<br>- Facilitates the presentation of personalized product collections, enabling users to view and interact with their saved favorites seamlessly within the apps user interface.</td>
																				</tr>
																				<tr style='border-bottom: 1px solid #eee;'>
																					<td style='padding: 8px;'><b><a href='https://github.com/GokalpPATAN/E-Commerce/blob/master/app/src/main/java/com/patan/commerce/fragments/user/PaymentMethodFragment.kt'>PaymentMethodFragment.kt</a></b></td>
																					<td style='padding: 8px;'>- Manages user payment methods within the application by enabling addition, display, and deletion of credit/debit cards<br>- Integrates with the user view model to fetch and update payment data, facilitating seamless payment method management in the user profile section<br>- Supports dynamic UI updates to reflect current payment options, ensuring an intuitive user experience.</td>
																				</tr>
																			</table>
																		</blockquote>
																	</details>
																	<!-- login Submodule -->
																	<details>
																		<summary><b>login</b></summary>
																		<blockquote>
																			<div class='directory-path' style='padding: 8px 0; color: #666;'>
																				<code><b>⦿ app.src.main.java.com.patan.commerce.fragments.login</b></code>
																			<table style='width: 100%; border-collapse: collapse;'>
																			<thead>
																				<tr style='background-color: #f8f9fa;'>
																					<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
																					<th style='text-align: left; padding: 8px;'>Summary</th>
																				</tr>
																			</thead>
																				<tr style='border-bottom: 1px solid #eee;'>
																					<td style='padding: 8px;'><b><a href='https://github.com/GokalpPATAN/E-Commerce/blob/master/app/src/main/java/com/patan/commerce/fragments/login/LoginFragment.kt'>LoginFragment.kt</a></b></td>
																					<td style='padding: 8px;'>- Facilitates user authentication by managing login interactions, validating credentials, and handling session persistence through shared preferences<br>- Integrates with the apps navigation flow to direct users to registration or password recovery screens and transitions authenticated users to the main application interface, ensuring a seamless login experience within the overall app architecture.</td>
																				</tr>
																				<tr style='border-bottom: 1px solid #eee;'>
																					<td style='padding: 8px;'><b><a href='https://github.com/GokalpPATAN/E-Commerce/blob/master/app/src/main/java/com/patan/commerce/fragments/login/RegisterFragment.kt'>RegisterFragment.kt</a></b></td>
																					<td style='padding: 8px;'>- Facilitates user registration by capturing input data, initiating registration requests through the ViewModel, and providing user feedback based on success or failure<br>- Integrates with navigation to transition users to email confirmation upon successful registration, supporting the overall authentication flow within the applications architecture.</td>
																				</tr>
																				<tr style='border-bottom: 1px solid #eee;'>
																					<td style='padding: 8px;'><b><a href='https://github.com/GokalpPATAN/E-Commerce/blob/master/app/src/main/java/com/patan/commerce/fragments/login/ConfirmEmailFragment.kt'>ConfirmEmailFragment.kt</a></b></td>
																					<td style='padding: 8px;'>- Facilitates email confirmation within the login flow by handling user input, triggering email verification through the view model, and navigating to the login screen upon successful confirmation<br>- Supports re-sending confirmation emails, ensuring a smooth user experience during account verification<br>- Integrates seamlessly into the apps authentication architecture, maintaining clear separation of UI and business logic.</td>
																				</tr>
																				<tr style='border-bottom: 1px solid #eee;'>
																					<td style='padding: 8px;'><b><a href='https://github.com/GokalpPATAN/E-Commerce/blob/master/app/src/main/java/com/patan/commerce/fragments/login/ResetPasswordFragment.kt'>ResetPasswordFragment.kt</a></b></td>
																					<td style='padding: 8px;'>- Facilitates user password reset by capturing input data and triggering the reset process within the authentication flow<br>- Integrates with the login view model to handle password update requests securely, ensuring a seamless user experience during account recovery<br>- Serves as a critical component in the authentication module, enabling users to regain account access through token-based verification.</td>
																				</tr>
																				<tr style='border-bottom: 1px solid #eee;'>
																					<td style='padding: 8px;'><b><a href='https://github.com/GokalpPATAN/E-Commerce/blob/master/app/src/main/java/com/patan/commerce/fragments/login/ForgotPasswordFragment.kt'>ForgotPasswordFragment.kt</a></b></td>
																					<td style='padding: 8px;'>Facilitates the user password recovery process by capturing input, initiating a password reset request via the ViewModel, and navigating to the reset password screen upon successful token retrieval, thereby supporting the overall authentication flow within the applications login architecture.</td>
																				</tr>
																			</table>
																		</blockquote>
																	</details>
																</blockquote>
															</details>
															<!-- viewmodels Submodule -->
															<details>
																<summary><b>viewmodels</b></summary>
																<blockquote>
																	<div class='directory-path' style='padding: 8px 0; color: #666;'>
																		<code><b>⦿ app.src.main.java.com.patan.commerce.viewmodels</b></code>
																	<table style='width: 100%; border-collapse: collapse;'>
																	<thead>
																		<tr style='background-color: #f8f9fa;'>
																			<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
																			<th style='text-align: left; padding: 8px;'>Summary</th>
																		</tr>
																	</thead>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/GokalpPATAN/E-Commerce/blob/master/app/src/main/java/com/patan/commerce/viewmodels/ProductsPagingSource.kt'>ProductsPagingSource.kt</a></b></td>
																			<td style='padding: 8px;'>- Facilitates efficient pagination of product comments by fetching data from the API, managing page states, and handling load errors<br>- Integrates seamlessly within the app’s architecture to enable smooth, incremental loading of user reviews, enhancing user experience and performance during comment browsing.</td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/GokalpPATAN/E-Commerce/blob/master/app/src/main/java/com/patan/commerce/viewmodels/AddressViewModel.kt'>AddressViewModel.kt</a></b></td>
																			<td style='padding: 8px;'>- Manages user address data within the applications architecture by orchestrating retrieval, addition, update, and deletion of addresses and city information<br>- Integrates with the AddressRepository to handle data operations, exposing state flows for UI components to observe address and city lists<br>- Facilitates seamless address management, ensuring synchronization between the user interface and backend data sources.</td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/GokalpPATAN/E-Commerce/blob/master/app/src/main/java/com/patan/commerce/viewmodels/BaseViewModel.kt'>BaseViewModel.kt</a></b></td>
																			<td style='padding: 8px;'>- Provides a foundational structure for managing UI-related state and communication within the applications architecture<br>- Facilitates handling success, error, and notification messages across various view models, promoting consistent state management and streamlined user feedback mechanisms throughout the app<br>- Serves as a base class to ensure uniform response handling in the MVVM architecture.</td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/GokalpPATAN/E-Commerce/blob/master/app/src/main/java/com/patan/commerce/viewmodels/CategoriesPagingSource.kt'>CategoriesPagingSource.kt</a></b></td>
																			<td style='padding: 8px;'>- Facilitates efficient pagination of products within specific categories by fetching data from the API, managing page states, and handling errors<br>- Integrates seamlessly into the app’s architecture to enable smooth, on-demand loading of product lists, enhancing user experience through dynamic content retrieval aligned with the overall commerce platform.</td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/GokalpPATAN/E-Commerce/blob/master/app/src/main/java/com/patan/commerce/viewmodels/UserViewModel.kt'>UserViewModel.kt</a></b></td>
																			<td style='padding: 8px;'>- Manages user-related data and actions within the application, including retrieving and updating user information, handling payment methods, and processing orders<br>- Serves as an intermediary between the user interface and data repositories, ensuring seamless user profile management and transaction workflows within the overall architecture.</td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/GokalpPATAN/E-Commerce/blob/master/app/src/main/java/com/patan/commerce/viewmodels/ProductsViewModel.kt'>ProductsViewModel.kt</a></b></td>
																			<td style='padding: 8px;'>- Manages product-related data and user interactions within the commerce application, including fetching product lists, details, categories, and handling cart, favorites, and reviews<br>- Serves as a central hub for coordinating UI updates and business logic, ensuring seamless user experiences across product browsing, shopping, and feedback functionalities within the app’s architecture.</td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/GokalpPATAN/E-Commerce/blob/master/app/src/main/java/com/patan/commerce/viewmodels/LoginViewModel.kt'>LoginViewModel.kt</a></b></td>
																			<td style='padding: 8px;'>- Manages user authentication workflows within the application, including login, registration, email confirmation, password reset, and re-confirmation processes<br>- Integrates with backend API services to handle user credential validation and account recovery, updating observable data for UI components to reflect authentication states and user information, thereby supporting secure and seamless user onboarding and account management.</td>
																		</tr>
																	</table>
																</blockquote>
															</details>
															<!-- utils Submodule -->
															<details>
																<summary><b>utils</b></summary>
																<blockquote>
																	<div class='directory-path' style='padding: 8px 0; color: #666;'>
																		<code><b>⦿ app.src.main.java.com.patan.commerce.utils</b></code>
																	<table style='width: 100%; border-collapse: collapse;'>
																	<thead>
																		<tr style='background-color: #f8f9fa;'>
																			<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
																			<th style='text-align: left; padding: 8px;'>Summary</th>
																		</tr>
																	</thead>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/GokalpPATAN/E-Commerce/blob/master/app/src/main/java/com/patan/commerce/utils/GlideExtension.kt'>GlideExtension.kt</a></b></td>
																			<td style='padding: 8px;'>- Provides extension functions to streamline image loading and manipulation within the app, enhancing the efficiency and consistency of displaying images across the user interface<br>- Integrates seamlessly with the Glide image loading library, supporting optimized image rendering and resource management, thereby contributing to a smoother user experience and maintaining clean, reusable code within the overall app architecture.</td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/GokalpPATAN/E-Commerce/blob/master/app/src/main/java/com/patan/commerce/utils/Constants.kt'>Constants.kt</a></b></td>
																			<td style='padding: 8px;'>- Defines essential constants and a DiffUtil callback to facilitate efficient comparison and updating of comment data within the app<br>- Supports consistent API interactions and optimized UI rendering by identifying unique comment items and detecting content changes, thereby enhancing overall data management and user experience in the applications architecture.</td>
																		</tr>
																	</table>
																</blockquote>
															</details>
															<!-- repositories Submodule -->
															<details>
																<summary><b>repositories</b></summary>
																<blockquote>
																	<div class='directory-path' style='padding: 8px 0; color: #666;'>
																		<code><b>⦿ app.src.main.java.com.patan.commerce.repositories</b></code>
																	<table style='width: 100%; border-collapse: collapse;'>
																	<thead>
																		<tr style='background-color: #f8f9fa;'>
																			<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
																			<th style='text-align: left; padding: 8px;'>Summary</th>
																		</tr>
																	</thead>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/GokalpPATAN/E-Commerce/blob/master/app/src/main/java/com/patan/commerce/repositories/UserRepository.kt'>UserRepository.kt</a></b></td>
																			<td style='padding: 8px;'>- Provides an interface for managing user-related operations within the applications architecture, including retrieving and updating user information, handling payment methods, and processing orders<br>- Acts as a bridge between the apps core logic and backend services, ensuring seamless data synchronization and transaction management across the user profile and payment workflows.</td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/GokalpPATAN/E-Commerce/blob/master/app/src/main/java/com/patan/commerce/repositories/AddressRepository.kt'>AddressRepository.kt</a></b></td>
																			<td style='padding: 8px;'>- Provides an interface for managing user addresses and location data within the application<br>- Facilitates fetching city and district information, retrieving user addresses, and performing create, update, or delete operations on addresses through network API calls<br>- Integrates seamlessly into the broader architecture to support location-based features and user address management workflows.</td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/GokalpPATAN/E-Commerce/blob/master/app/src/main/java/com/patan/commerce/repositories/ProductsRepository.kt'>ProductsRepository.kt</a></b></td>
																			<td style='padding: 8px;'>- Provides an interface for managing product-related data within the application, including fetching product details, categories, comments, and handling cart and favorite operations<br>- Integrates with the API service to facilitate seamless data retrieval and updates, supporting features like product browsing, cart management, and user preferences, thereby enabling a cohesive e-commerce experience within the apps architecture.</td>
																		</tr>
																	</table>
																</blockquote>
															</details>
															<!-- di Submodule -->
															<details>
																<summary><b>di</b></summary>
																<blockquote>
																	<div class='directory-path' style='padding: 8px 0; color: #666;'>
																		<code><b>⦿ app.src.main.java.com.patan.commerce.di</b></code>
																	<table style='width: 100%; border-collapse: collapse;'>
																	<thead>
																		<tr style='background-color: #f8f9fa;'>
																			<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
																			<th style='text-align: left; padding: 8px;'>Summary</th>
																		</tr>
																	</thead>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/GokalpPATAN/E-Commerce/blob/master/app/src/main/java/com/patan/commerce/di/Qualifiers.kt'>Qualifiers.kt</a></b></td>
																			<td style='padding: 8px;'>- Defines custom qualifiers for dependency injection, enabling precise identification and provision of specific dependencies such as tokens and user IDs within the applications architecture<br>- These annotations facilitate clear separation of concerns and improve modularity by ensuring the correct instances are injected where needed, supporting scalable and maintainable code organization across the project.</td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/GokalpPATAN/E-Commerce/blob/master/app/src/main/java/com/patan/commerce/di/RetrofitModule.kt'>RetrofitModule.kt</a></b></td>
																			<td style='padding: 8px;'>- Provides dependency injection setup for network communication by configuring and supplying a singleton Retrofit instance, an OkHttpClient with logging, and the ApiService interface<br>- Facilitates seamless API interactions across the application, ensuring consistent network configurations and enabling efficient communication with backend services within the overall architecture.</td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/GokalpPATAN/E-Commerce/blob/master/app/src/main/java/com/patan/commerce/di/ViewModelsModule.kt'>ViewModelsModule.kt</a></b></td>
																			<td style='padding: 8px;'>- Defines dependency injection for shared preferences, providing singleton instances of user-specific data such as tokens and user IDs<br>- Integrates with the applications architecture to ensure consistent access to these values across the app, facilitating secure and efficient management of user session information within the overall project structure.</td>
																		</tr>
																	</table>
																</blockquote>
															</details>
															<!-- model Submodule -->
															<details>
																<summary><b>model</b></summary>
																<blockquote>
																	<div class='directory-path' style='padding: 8px 0; color: #666;'>
																		<code><b>⦿ app.src.main.java.com.patan.commerce.model</b></code>
																	<table style='width: 100%; border-collapse: collapse;'>
																	<thead>
																		<tr style='background-color: #f8f9fa;'>
																			<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
																			<th style='text-align: left; padding: 8px;'>Summary</th>
																		</tr>
																	</thead>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/GokalpPATAN/E-Commerce/blob/master/app/src/main/java/com/patan/commerce/model/Request.kt'>Request.kt</a></b></td>
																			<td style='padding: 8px;'>- Defines data models for various API requests within the commerce application, facilitating structured communication between the client and backend services<br>- These request classes support user authentication, profile management, product retrieval, cart operations, order processing, and feedback submission, serving as the foundational data contracts that enable seamless and organized data exchange across the applications architecture.</td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/GokalpPATAN/E-Commerce/blob/master/app/src/main/java/com/patan/commerce/model/ApiResponse.kt'>ApiResponse.kt</a></b></td>
																			<td style='padding: 8px;'>- Defines a generic ApiResponse model to standardize server responses across the application<br>- It encapsulates data payloads, status messages, severity levels, and success indicators, facilitating consistent handling of API interactions within the overall architecture<br>- This structure supports reliable data exchange and streamlined error management throughout the app’s communication layer.</td>
																		</tr>
																		<tr style='border-bottom: 1px solid #eee;'>
																			<td style='padding: 8px;'><b><a href='https://github.com/GokalpPATAN/E-Commerce/blob/master/app/src/main/java/com/patan/commerce/model/Data.kt'>Data.kt</a></b></td>
																			<td style='padding: 8px;'>- Defines data models representing core entities such as users, products, categories, addresses, cart items, comments, and payment methods within the e-commerce platform<br>- These models facilitate structured data handling, serialization, and parceling across the app, supporting functionalities like user management, product browsing, cart operations, and order processing, thereby underpinning the applications data architecture.</td>
																		</tr>
																	</table>
																</blockquote>
															</details>
														</blockquote>
													</details>
												</blockquote>
											</details>
										</blockquote>
									</details>
								</blockquote>
							</details>
						</blockquote>
					</details>
					<!-- test Submodule -->
					<details>
						<summary><b>test</b></summary>
						<blockquote>
							<div class='directory-path' style='padding: 8px 0; color: #666;'>
								<code><b>⦿ app.src.test</b></code>
							<!-- java Submodule -->
							<details>
								<summary><b>java</b></summary>
								<blockquote>
									<div class='directory-path' style='padding: 8px 0; color: #666;'>
										<code><b>⦿ app.src.test.java</b></code>
									<!-- com Submodule -->
									<details>
										<summary><b>com</b></summary>
										<blockquote>
											<div class='directory-path' style='padding: 8px 0; color: #666;'>
												<code><b>⦿ app.src.test.java.com</b></code>
											<!-- patan Submodule -->
											<details>
												<summary><b>patan</b></summary>
												<blockquote>
													<div class='directory-path' style='padding: 8px 0; color: #666;'>
														<code><b>⦿ app.src.test.java.com.patan</b></code>
													<!-- commerce Submodule -->
													<details>
														<summary><b>commerce</b></summary>
														<blockquote>
															<div class='directory-path' style='padding: 8px 0; color: #666;'>
																<code><b>⦿ app.src.test.java.com.patan.commerce</b></code>
															<table style='width: 100%; border-collapse: collapse;'>
															<thead>
																<tr style='background-color: #f8f9fa;'>
																	<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
																	<th style='text-align: left; padding: 8px;'>Summary</th>
																</tr>
															</thead>
																<tr style='border-bottom: 1px solid #eee;'>
																	<td style='padding: 8px;'><b><a href='https://github.com/GokalpPATAN/E-Commerce/blob/master/app/src/test/java/com/patan/commerce/ExampleUnitTest.kt'>ExampleUnitTest.kt</a></b></td>
																	<td style='padding: 8px;'>- Provides a basic validation mechanism within the project’s testing suite, ensuring core arithmetic operations function correctly<br>- Serves as a foundational example of unit testing practices in the codebase, supporting the overall quality assurance process by verifying individual components work as expected during development<br>- Facilitates early detection of errors, contributing to the stability of the application.</td>
																</tr>
															</table>
														</blockquote>
													</details>
												</blockquote>
											</details>
										</blockquote>
									</details>
								</blockquote>
							</details>
						</blockquote>
					</details>
					<!-- androidTest Submodule -->
					<details>
						<summary><b>androidTest</b></summary>
						<blockquote>
							<div class='directory-path' style='padding: 8px 0; color: #666;'>
								<code><b>⦿ app.src.androidTest</b></code>
							<!-- java Submodule -->
							<details>
								<summary><b>java</b></summary>
								<blockquote>
									<div class='directory-path' style='padding: 8px 0; color: #666;'>
										<code><b>⦿ app.src.androidTest.java</b></code>
									<!-- com Submodule -->
									<details>
										<summary><b>com</b></summary>
										<blockquote>
											<div class='directory-path' style='padding: 8px 0; color: #666;'>
												<code><b>⦿ app.src.androidTest.java.com</b></code>
											<!-- patan Submodule -->
											<details>
												<summary><b>patan</b></summary>
												<blockquote>
													<div class='directory-path' style='padding: 8px 0; color: #666;'>
														<code><b>⦿ app.src.androidTest.java.com.patan</b></code>
													<!-- commerce Submodule -->
													<details>
														<summary><b>commerce</b></summary>
														<blockquote>
															<div class='directory-path' style='padding: 8px 0; color: #666;'>
																<code><b>⦿ app.src.androidTest.java.com.patan.commerce</b></code>
															<table style='width: 100%; border-collapse: collapse;'>
															<thead>
																<tr style='background-color: #f8f9fa;'>
																	<th style='width: 30%; text-align: left; padding: 8px;'>File Name</th>
																	<th style='text-align: left; padding: 8px;'>Summary</th>
																</tr>
															</thead>
																<tr style='border-bottom: 1px solid #eee;'>
																	<td style='padding: 8px;'><b><a href='https://github.com/GokalpPATAN/E-Commerce/blob/master/app/src/androidTest/java/com/patan/commerce/ExampleInstrumentedTest.kt'>ExampleInstrumentedTest.kt</a></b></td>
																	<td style='padding: 8px;'>- Verifies the integrity of the applications package name within the Android environment, ensuring correct app context during testing<br>- Integrates into the testing framework to validate that the apps core identity remains consistent across different device configurations, supporting reliable and accurate instrumented testing within the overall mobile commerce architecture.</td>
																</tr>
															</table>
														</blockquote>
													</details>
												</blockquote>
											</details>
										</blockquote>
									</details>
								</blockquote>
							</details>
						</blockquote>
					</details>
				</blockquote>
			</details>
		</blockquote>
	</details>
</details>

---

## 🚀 Getting Started

### 📋 Prerequisites

This project requires the following dependencies:

- **Programming Language:** Kotlin
- **Package Manager:** Gradle

### ⚙️ Installation

Build E-Commerce from the source and install dependencies:

1. **Clone the repository:**

    ```sh
    ❯ git clone https://github.com/GokalpPATAN/E-Commerce
    ```

2. **Navigate to the project directory:**

    ```sh
    ❯ cd E-Commerce
    ```

3. **Install the dependencies:**

**Using [gradle](https://kotlinlang.org/):**

```sh
❯ gradle build
```

### 💻 Usage

Run the project with:

**Using [gradle](https://kotlinlang.org/):**

```sh
gradle run
```

### 🧪 Testing

E-commerce uses the {__test_framework__} test framework. Run the test suite with:

**Using [gradle](https://kotlinlang.org/):**

```sh
gradle test
```

---

## 📈 Roadmap

- [X] **`Task 1`**: <strike>Implement feature one.</strike>
- [ ] **`Task 2`**: Implement feature two.
- [ ] **`Task 3`**: Implement feature three.

---

## 📜 License

E-commerce is protected under the [LICENSE](https://choosealicense.com/licenses) License. For more details, refer to the [LICENSE](https://choosealicense.com/licenses/) file.

---

## ✨ Acknowledgments

- Credit `contributors`, `inspiration`, `references`, etc.

<div align="left"><a href="#top">⬆ Return</a></div>

---
