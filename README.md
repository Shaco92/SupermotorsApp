# SuperMotors App: Catálogo y Guía Móvil de Superdeportivas e Hyperbikes

Aplicación móvil nativa para Android desarrollada en **Java y XML** con arquitectura modular basada en **Fragments**, diseñada para la asignatura **Herramientas de Programación Móvil 1** del **Politécnico Grancolombiano**.

---

## 🏍️ Descripción del Proyecto

**SuperMotors App** es una plataforma móvil interactiva creada para aficionados y conocedores de las motocicletas deportivas y de alto rendimiento. La aplicación implementa el diseño en pantalla dividida (*Split Screen Layout*: 35% menú lateral de control y 65% área de contenido dinámico) y cumple con los módulos y lineamientos solicitados en la guía de proyectos del curso (`Ideas Proyectos_A.html`), adaptados a la industria del motor y superdeportivas:

1. **🏁 Catálogo de Selección:** Catálogo completo de superdeportivas e hyperbikes (Honda CBR600RR, Yamaha YZF-R1, Ducati Panigale V4, BMW S 1000 RR, Kawasaki Ninja ZX-10R, Suzuki Hayabusa) con barra de búsqueda en tiempo real, chips de filtrado por categoría (`Todas`, `Superbike`, `Deportiva`, `Hyperbike`, `⭐ Mi Garaje`), badges de potencia y velocidad, y botón rápido para guardar en favoritas.
2. **👤 1. Perfil (`ProfileFragment`):** Ficha principal del modelo con fotografía destacada, año, cilindraje, potencia en CV, velocidad máxima, peso en orden de marcha, precio sugerido en pesos colombianos (COP) y reseña histórica y técnica.
3. **📸 2. Fotos (`PhotosFragment`):** Galería fotográfica con 3 capturas en alta definición de cada motocicleta (vista estática, ángulo aerodinámico y acción en pista).
4. **🎬 3. Video (`VideoFragment`):** Cápsula audiovisual interactiva con reproducción in-app de videos oficiales de YouTube, portada con badges de calidad 4K UHD 60 FPS, duración del clip, indicadores de telemetría (aceleración 0-100 km/h, potencia a RPM, velocidad punta), botón de reproducción externa en navegador y función para compartir el video.
5. **⚙️ 4. Ficha Técnica (`SpecsFragment`):** Tabla completa de especificaciones mecánicas: arquitectura de motor, válvulas, torque máximo, sistema de frenos Brembo/radiales, capacidad de combustible y altura del asiento.
6. **🌐 5. Web In-App (`WebFragment`):** Navegador web integrado con barra de direcciones interactiva (`EditText` editable y botón "IR") que carga el portal oficial del fabricante (Honda, Yamaha, Ducati, BMW, Kawasaki, Suzuki) sin abandonar la app.
7. **🔘 6. Botones & Acciones Dinámicas (`ButtonsFragment`):**
   - **📋 Ver Especificaciones Rápidas:** Cuadro de diálogo `AlertDialog` con el resumen clave del vehículo.
   - **💰 Ver Precio & Financiación:** Visualización del precio en COP, simulación de crédito con cuota inicial del 20%, saldo restante en 48 cuotas y enlace a concesionarios.
   - **📢 Compartir Ficha:** Uso del `Intent.ACTION_SEND` nativo de Android para compartir la ficha técnica de la moto por WhatsApp, Telegram y redes sociales.
   - **❤️ / ⭐ Mi Garaje (Favoritos):** Marcador de guardado persistente en memoria que actualiza el estado en el catálogo y permite filtrar las motos preferidas.
   - **🔧 Mantenimiento & SOAT:** Guía de servicio preventivo cada 5.000 km, especificación de lubricante sintético 10W-40 y tarifas de SOAT vigentes en Colombia para motos mayores a 200cc.
8. **🔄 Cambiar Moto:** Retorno instantáneo al catálogo para explorar otro modelo.

---

## 📁 Arquitectura del Código (Java / Android Nativo)

```
app/src/main/
├── AndroidManifest.xml
├── java/com/supermotors/app/
│   ├── MainActivity.java               // Actividad principal y control de navegación
│   ├── Bike.java                       // Modelo de datos Serializable con soporte de video y precio
│   ├── BikeRepository.java             // Repositorio de datos con 6 motocicletas y lógica de filtrado
│   ├── BikeAdapter.java                // Adaptador RecyclerView con soporte de favoritos y métricas
│   ├── ImageLoader.java                // Utilidad desacoplada para carga de imágenes
│   ├── OnMenuSelectionListener.java    // Interfaz de comunicación entre fragmentos y actividad
│   ├── BikeListFragment.java           // Pantalla de catálogo con buscador reactivo y chips
│   ├── MenuFragment.java               // Menú lateral interactivo con avatar y opciones
│   ├── ProfileFragment.java            // Pestaña 1: Perfil y especificaciones base
│   ├── PhotosFragment.java             // Pestaña 2: Galería de fotos del modelo
│   ├── VideoFragment.java              // Pestaña 3: Cápsula de video oficial y telemetría
│   ├── SpecsFragment.java              // Pestaña 4: Ficha técnica mecánica
│   ├── WebFragment.java                // Pestaña 5: Navegador web institucional in-app
│   └── ButtonsFragment.java            // Pestaña 6: Botones dinámicos y simulador financiero
└── res/
    ├── drawable/                       // Íconos vectoriales (ic_video, ic_favorite, etc.) y fondos shape
    ├── layout/                         // Archivos de maquetación XML de actividad y fragmentos
    ├── values/                         // Colores (paleta burdeos y blanco), cadenas y temas
    └── mipmap/                         // Íconos de la aplicación
```

---

## 🚀 Cómo Abrir y Ejecutar en Android Studio

1. Abre **Android Studio** (Hedgehog, Iguana, Koala, Ladybug o superior).
2. Selecciona **File → Open** y busca la carpeta `App/SuperMoto/SupermotorsApp`.
3. Espera a que Gradle descargue las dependencias y sincronice el proyecto (`Sync Project with Gradle Files`).
4. Selecciona un dispositivo virtual (AVD) con **Android 6.0 (API 23) o superior** (se recomienda Android 12, 13 o 14).
5. Haz clic en el botón verde **Run 'app'** (`Shift + F10`).

---

## 🐙 Cómo Cargar el Proyecto a GitHub

Desde la terminal de comandos (PowerShell o Git Bash) dentro de la carpeta `SupermotorsApp`:

```bash
# 1. Verificar estado de los archivos modificados y agregados
git status

# 2. Agregar todos los cambios al área de preparación
git add .

# 3. Realizar el commit formal de entrega
git commit -m "feat: completar modulo de video, botones dinamicos, buscador y entregables web"

# 4. Asegurar rama principal
git branch -M main

# 5. Subir cambios al repositorio remoto
git push -u origin main
```

---

## 🌐 Enlace Público del Mockup y Documentación (GitHub Pages)

La aplicación cuenta con una réplica interactiva en HTML/CSS/JS con simulador de smartphone y diagrama de arquitectura:
👉 **[https://Shaco92.github.io/SupermotorsApp/](https://Shaco92.github.io/SupermotorsApp/)**

---

## 🛠️ Requisitos Técnicos

- **Lenguaje:** Java 8 / Java 17
- **Arquitectura UI:** XML Layouts tradicionales con `FragmentManager` y `FragmentTransaction`
- **minSdk:** 23 (Android 6.0 Marshmallow)
- **targetSdk / compileSdk:** 34 (Android 14)
- **Componentes:** AndroidX AppCompat, Material Design Components (`com.google.android.material:material:1.9.0`), ConstraintLayout (`2.1.4`)
- **Gradle:** Wrapper 8.7 con Android Gradle Plugin 8.3+

---

## 👥 Datos de Entrega

- **Asignatura:** Herramientas de Programación Móvil 1
- **Docente:** Ing. Mg. Víctor Castro P.
- **Institución:** Politécnico Grancolombiano
- **Proyecto:** SuperMotors App (Catálogo de Motocicletas de Alto Desempeño)
