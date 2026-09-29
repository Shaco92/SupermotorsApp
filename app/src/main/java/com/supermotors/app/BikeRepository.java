package com.supermotors.app;

import java.util.ArrayList;
import java.util.List;

public class BikeRepository {
    private static List<Bike> bikes;

    public static List<Bike> getBikes() {
        if (bikes == null) {
            bikes = new ArrayList<>();
            
            bikes.add(new Bike(
                    "HONDA CBR600RR",
                    "Deportiva",
                    "2024",
                    "599 cc",
                    "121 CV @ 14,250 rpm",
                    "260 km/h",
                    "193 kg",
                    "La nueva CBR600RR es una máquina de precisión absoluta. Con un motor tetracilíndrico aullador y un paquete electrónico derivado de MotoGP, es la reina de las 600.",
                    R.drawable.honda_main,
                    "",
                    "https://www.honda.es/motorcycles/range/super-sport/cbr600rr/overview.html",
                    new int[]{R.drawable.honda_1, R.drawable.honda_2, R.drawable.honda_3},
                    new String[]{"", "", ""},
                    "63 Nm @ 11,500 rpm",
                    "Tetracilíndrico en línea, 16 válvulas",
                    "18 Litros",
                    "822 mm",
                    "Doble disco 310mm, pinzas radiales 4 pistones"
            ));

            bikes.add(new Bike(
                    "YAMAHA YZF-R1",
                    "Superbike",
                    "2024",
                    "998 cc",
                    "200 CV @ 13,500 rpm",
                    "299 km/h",
                    "201 kg",
                    "Desarrollada con la tecnología de la M1 de MotoGP, la R1 cuenta con un motor crossplane, chasis de corta distancia entre ejes y una electrónica de vanguardia.",
                    R.drawable.yamaha_main,
                    "",
                    "https://yamahayamamotos.com.co/motocicletas/superdeportivas/r1/",
                    new int[]{R.drawable.yamaha_1, R.drawable.yamaha_2, R.drawable.yamaha_3},
                    new String[]{"", "", ""},
                    "113.3 Nm @ 11,500 rpm",
                    "4 cilindros, 4 tiempos, refrigerado por líquido",
                    "17 Litros",
                    "855 mm",
                    "Doble disco de 320 mm, pinzas monobloque"
            ));

            bikes.add(new Bike(
                    "DUCATI PANIGALE V4",
                    "Superbike",
                    "2024",
                    "1,103 cc",
                    "215.5 CV @ 13,000 rpm",
                    "300+ km/h",
                    "195.5 kg",
                    "La Panigale V4 es la culminación de la ingeniería italiana. Potencia bruta y elegancia aerodinámica para dominar cualquier circuito del mundo.",
                    R.drawable.ducati_main,
                    "",
                    "https://www.ducati.com/ww/en/bikes/panigale/panigale-v4",
                    new int[]{R.drawable.ducati_1, R.drawable.ducati_2, R.drawable.ducati_3},
                    new String[]{"", "", ""},
                    "123.6 Nm @ 9,500 rpm",
                    "Desmosedici Stradale V4 a 90°",
                    "17 Litros",
                    "850 mm",
                    "Brembo Stylema monobloque de 4 pistones"
            ));

            bikes.add(new Bike(
                    "BMW S 1000 RR",
                    "Superbike",
                    "2024",
                    "999 cc",
                    "210 CV @ 13,750 rpm",
                    "303 km/h",
                    "197 kg",
                    "La S 1000 RR es ahora todavía más precisa y está más centrada en el rendimiento. Con alerones aerodinámicos y tecnología ShiftCam para una potencia máxima.",
                    R.drawable.bmw_main,
                    "",
                    "https://www.bmw-motorrad.es/es/models/sport/s1000rr.html",
                    new int[]{R.drawable.bmw_1, R.drawable.bmw_2, R.drawable.bmw_3},
                    new String[]{"", "", ""},
                    "113 Nm @ 11,000 rpm",
                    "Tetracilíndrico en línea, ShiftCam",
                    "16.5 Litros",
                    "832 mm",
                    "Doble disco 320mm, pinzas BMW de 4 pistones"
            ));

            bikes.add(new Bike(
                    "KAWASAKI NINJA ZX-10R",
                    "Superbike",
                    "2024",
                    "998 cc",
                    "203 CV @ 13,200 rpm",
                    "298 km/h",
                    "207 kg",
                    "Seis veces campeona consecutiva del WorldSBK, la Ninja ZX-10R es la prueba definitiva de que la potencia sin control no sirve de nada.",
                    R.drawable.kawasaki_main,
                    "",
                    "https://www.kawasaki.es/es/products/Supersport/2024/Ninja_ZX-10R/overview",
                    new int[]{R.drawable.kawasaki_1, R.drawable.kawasaki_2, R.drawable.kawasaki_3},
                    new String[]{"", "", ""},
                    "114.9 Nm @ 11,400 rpm",
                    "Tetracilíndrico en línea, refrigeración líquida",
                    "17 Litros",
                    "835 mm",
                    "Doble disco Brembo de 330 mm, M50"
            ));

            bikes.add(new Bike(
                    "SUZUKI HAYABUSA SPECIAL EDITION",
                    "Hyperbike",
                    "2024",
                    "1,340 cc",
                    "190 CV @ 9,700 rpm",
                    "299 km/h",
                    "264 kg",
                    "La Suzuki Hayabusa Special Edition celebra 25 años de velocidad. Con su motor legendario de 1340cc y una aerodinámica inconfundible, sigue siendo la reina de las autopistas.",
                    R.drawable.suzuki_main,
                    "",
                    "https://moto.suzuki.es/motos/deportivas/2026/hayabusa-edicion-especial",
                    new int[]{R.drawable.suzuki_1, R.drawable.suzuki_2, R.drawable.suzuki_3},
                    new String[]{"", "", ""},
                    "150 Nm @ 7,000 rpm",
                    "4 cilindros, 1.340 cc",
                    "20 Litros",
                    "800 mm",
                    "Brembo Stylema radiales de 4 pistones"
            ));
        }
        return bikes;
    }
}
