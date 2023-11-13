package com.example.tp3.data.service

import com.example.tp3.models.Neighbor

class DummyNeighborApiService : NeighborApiService {

    override val neighbours: List<Neighbor>
        get() = DUMMY_NeighborS

    override fun deleteNeighbour(neighbor: Neighbor): Boolean {
       return DUMMY_NeighborS.remove(neighbor)
    }

    override fun createNeighbour(neighbor: Neighbor):Boolean {
        if (neighbor != null){
            DUMMY_NeighborS.add(neighbor)
            return true
        }
        else {
            return false
        }

    }

    override fun updateFavoriteStatus(neighbor: Neighbor) {
        TODO("Not yet implemented")
    }

    override fun updateDataNeighbour(neighbor: Neighbor) {
        TODO("Not yet implemented")
    }


    private val DUMMY_NeighborS: MutableList<Neighbor> = mutableListOf(
        Neighbor(
            1, "Caroline",
            "https://www.kasandbox.org/programming-images/avatars/spunky-sam.png",
            "Saint-Pierre-du-Mont ; 5km",
            "+33 6 86 57 90 14",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                    "Pellentesque porttitor id sem ut blandit. Lorem ipsum dolor sit amet, " +
                    "consectetur adipiscing elit. Donec sed hendrerit ex. Cras a tempus risus. " +
                    "Aliquam egestas nulla non luctus blandit. Aenean dignissim massa ultrices volutpat bibendum. " +
                    "Integer semper diam et lorem iaculis pulvinar.",
            true,
            "www.facebook.fr/caroline"
        ),
        Neighbor(
            2,
            "Jack",
            "https://www.kasandbox.org/programming-images/avatars/spunky-sam.png",
            "Saint-Pierre-du-Mont ; 5km",
            "+33 6 00 55 90 14",
            ("Sed eget fringilla mauris, ac rutrum mauris. Curabitur finibus felis id justo porttitor, " +
                    "vitae hendrerit justo imperdiet. Donec tempus quam vulputate, elementum arcu a, molestie felis. " +
                    "Pellentesque eu risus luctus, tincidunt odio at, volutpat magna. Nam scelerisque vitae est vitae fermentum. " +
                    "Cras suscipit pretium ex, ut condimentum lorem sagittis sit amet. Praesent et gravida diam, at commodo lorem. " +
                    "Praesent tortor dui, fermentum vitae sollicitudin ut, elementum ut magna. Nulla volutpat tincidunt lectus, vel malesuada " +
                    "ante ultrices id.\n\n" +
                    "Ut scelerisque fringilla leo vitae dictum. Nunc suscipit urna tellus, a elementum eros accumsan vitae. " +
                    "Nunc lacinia turpis eu consectetur elementum. Cras scelerisque laoreet mauris ac pretium. Nam pellentesque " +
                    "ut orci ut scelerisque. Aliquam quis metus egestas, viverra neque vel, ornare velit. Nullam lobortis justo et ipsum " +
                    "sodales sodales. Etiam volutpat laoreet tellus, ultrices maximus nulla luctus ultricies. Praesent a dapibus arcu. In at magna " +
                    "in velit placerat vehicula nec in purus."),
            true,
            "www.facebook.fr/jack"
        ),
        Neighbor(
            3,
            "Chloé",
            "https://www.kasandbox.org/programming-images/avatars/spunky-sam.png",
            "Saint-Pierre-du-Mont ; 6km",
            "+33 6 86 13 12 14",
            "Sed ultricies suscipit semper. Fusce non blandit quam. ",
            false,
            "www.facebook.fr/chloe"
        ),
        Neighbor(
            4,
            "Vincent",
            "https://www.kasandbox.org/programming-images/avatars/spunky-sam.png",
            "Saint-Pierre-du-Mont ; 11km",
            "+33 6 10 57 90 19",
            ("Etiam quis neque egestas, consectetur est quis, laoreet augue. " +
                    "Interdum et malesuada fames ac ante ipsum primis in faucibus. Morbi ipsum sem, " +
                    "commodo in nisi maximus, semper dignissim metus. Fusce eget nunc sollicitudin, dignissim " +
                    "tortor quis, consectetur mauris. "),
            true,
            "www.facebook.fr/vincent"
        ),
        Neighbor(
            5,
            "Elodie",
            "https://www.kasandbox.org/programming-images/avatars/spunky-sam.png",
            "Saint-Pierre-du-Mont ; 8km",
            "+33 6 86 57 90 14",
            ("Fusce in ligula mi. Aliquam in sagittis tellus. Suspendisse tempor, velit et " +
                    "cursus facilisis, eros sapien sollicitudin mauris, et ultrices " +
                    "lectus sapien in neque. "),
            true,
            "www.facebook.fr/elodie"
        ),
        Neighbor(
            6,
            "Sylvain",
            "https://www.kasandbox.org/programming-images/avatars/spunky-sam.png",
            "Saint-Pierre-du-Mont ; 6km",
            "+33 6 86 12 22 02",
            ("Integer pulvinar lacinia augue, a tempor ex semper eget. Nam lacinia " +
                    "lorem dapibus, pharetra ante in, auctor urna. Praesent sollicitudin metus sit " +
                    "amet nunc lobortis sodales. In eget ante congue, vestibulum leo ac, placerat leo. " +
                    "Nullam arcu purus, cursus a sollicitudin eu, lobortis vitae est. Sed sodales sit " +
                    "amet magna nec finibus. Nulla pellentesque, justo ut bibendum mollis, urna diam " +
                    "hendrerit dolor, non gravida urna quam id eros. "),
            false,
            "www.facebook.fr/sylvain"
        ),
        Neighbor(
            7,
            "Laetitia",
            "https://www.kasandbox.org/programming-images/avatars/spunky-sam.png",
            "Saint-Pierre-du-Mont ; 14km",
            "+33 6 96 57 90 01",
            "Vestibulum non leo vel mi ultrices pellentesque. ",
            true,
            "www.facebook.fr/laetitia"
        ),
        Neighbor(
            8,
            "Dan",
            "https://www.kasandbox.org/programming-images/avatars/spunky-sam.png",
            "Saint-Pierre-du-Mont ; 1km",
            "+33 6 86 57 90 14",
            "Cras non dapibus arcu. ",
            true,
            "www.facebook.fr/dan"
        ),
        Neighbor(
            9,
            "Joseph",
            "https://www.kasandbox.org/programming-images/avatars/spunky-sam.png",
            "Saint-Pierre-du-Mont ; 2km",
            "+33 6 86 57 90 14",
            ("Donec neque odio, eleifend a luctus ac, tempor non libero. " +
                    "Nunc ullamcorper, erat non viverra feugiat, massa odio facilisis ligula, " +
                    "ut pharetra risus libero eget elit. Nulla malesuada, purus eu malesuada malesuada, est " +
                    "purus ullamcorper ipsum, quis congue velit mi sed lorem."),
            false,
            "www.facebook.fr/joseph"
        ),
        Neighbor(
            10,
            "Emma",
            "https://www.kasandbox.org/programming-images/avatars/spunky-sam.png",
            "Saint-Pierre-du-Mont ; 1km",
            "+33 6 14 71 70 18",
            ("Aliquam erat volutpat. Mauris at massa nibh. Suspendisse auctor fermentum orci, " +
                    "nec auctor tortor. Ut eleifend euismod turpis vitae tempus. Sed a tincidunt ex. Etiam ut " +
                    "nibh ante. Fusce maximus lorem nibh, at sollicitudin ante ultrices vel. Praesent ac luctus ante, eu " +
                    "lacinia diam. Quisque malesuada vel arcu vitae euismod. Ut egestas mattis euismod.\n\n" +
                    "Vestibulum non leo vel mi ultrices pellentesque. Praesent ornare ligula " +
                    "non elit consectetur, pellentesque fringilla eros placerat. Etiam consequat dui " +
                    "eleifend justo iaculis, ac ullamcorper velit consectetur. Aliquam vitae elit ac ante ultricies aliquet " +
                    "vel at felis. Suspendisse ac placerat odio. Cras non dapibus arcu. Fusce pharetra nisi at orci rhoncus, " +
                    "vitae tristique nibh euismod."),
            false,
            "www.facebook.fr/emma"
        ),
        Neighbor(
            11,
            "Patrick",
            "https://www.kasandbox.org/programming-images/avatars/spunky-sam.png",
            "Saint-Pierre-du-Mont ; 5km",
            "+33 6 20 40 60 80",
            ("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce porttitor molestie " +
                    "libero, nec porta lectus posuere a. Curabitur in purus at enim commodo accumsan. Nullam molestie diam a massa finibus, in bibendum " +
                    "nulla ullamcorper. Nunc at enim enim. Maecenas quis posuere nisi. Mauris suscipit cursus velit id condimentum. Ut finibus turpis " +
                    "at nulla finibus sollicitudin. Nunc dolor mauris, blandit id ullamcorper vel, lacinia ac nisi. Vestibulum et sapien tempor, " +
                    "egestas lorem vitae, faucibus urna. Duis id odio massa. Class aptent taciti sociosqu ad litora torquent per conubia nostra, " +
                    "per inceptos himenaeos.\n\nLorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce porttitor molestie  " +
                    "libero, nec porta lectus posuere a. Curabitur in purus at enim commodo accumsan. Nullam molestie diam a massa finibus, in bibendum " +
                    "nulla ullamcorper. Nunc at enim enim. Maecenas quis posuere nisi. Mauris suscipit cursus velit id condimentum. Ut finibus turpis " +
                    "at nulla finibus sollicitudin. Nunc dolor mauris, blandit id ullamcorper vel, lacinia ac nisi. Vestibulum et sapien tempor, " +
                    "egestas lorem vitae, faucibus urna. Duis id odio massa. Class aptent taciti sociosqu ad litora torquent per conubia nostra, " +
                    "per inceptos himenaeos."),
            true,
            "www.facebook.fr/patrick"
        ),
        Neighbor(
            12,
            "Ludovic",
            "https://www.kasandbox.org/programming-images/avatars/spunky-sam.png",
            "Saint-Pierre-du-Mont ; 5km",
            "+33 6 00 01 10 11",
            ("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce porttitor molestie " +
                    "libero, nec porta lectus posuere a. Curabitur in purus at enim commodo accumsan. Nullam molestie diam a massa finibus, in bibendum " +
                    "nulla ullamcorper. Nunc at enim enim. Maecenas quis posuere nisi. Mauris suscipit cursus velit id condimentum. Ut finibus turpis " +
                    "at nulla finibus sollicitudin. Nunc dolor mauris, blandit id ullamcorper vel, lacinia ac nisi. Vestibulum et sapien tempor, " +
                    "egestas lorem vitae, faucibus urna. Duis id odio massa. Class aptent taciti sociosqu ad litora torquent per conubia nostra, " +
                    "per inceptos himenaeos.\n\nLorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce porttitor molestie  " +
                    "libero, nec porta lectus posuere a. Curabitur in purus at enim commodo accumsan. Nullam molestie diam a massa finibus, in bibendum " +
                    "nulla ullamcorper. Nunc at enim enim. Maecenas quis posuere nisi. Mauris suscipit cursus velit id condimentum. Ut finibus turpis " +
                    "at nulla finibus sollicitudin. Nunc dolor mauris, blandit id ullamcorper vel, lacinia ac nisi. Vestibulum et sapien tempor, " +
                    "egestas lorem vitae, faucibus urna. Duis id odio massa. Class aptent taciti sociosqu ad litora torquent per conubia nostra, " +
                    "per inceptos himenaeos."),
            false,
            "www.facebook.fr/ludovic"
        )
    )


}