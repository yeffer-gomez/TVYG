package com.example.tvyg
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.tvyg.databinding.ActivityListBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityListBinding
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = binding.recyclerView
        recyclerView.layoutManager = GridLayoutManager(this, 3)

        // URLs de las imágenes existentes
        val imageUrls = listOf(


            "https://i.ytimg.com/vi/RT2C4PGI79Y/maxresdefault.jpg",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSMcFCYsIIF0F6DmFDQKJE0C-mbM8wZj9_OAg&s",
            "https://yt3.googleusercontent.com/31TDu-4WwXizR--Zf3v3yBcjRRKDN4uGudyBTVvbtnT8507xBrIe7Qu-_ieGf_6NLyjagAgiFuY=s900-c-k-c0x00ffffff-no-rj",
            "https://yt3.googleusercontent.com/ytc/AIdro_n6zSKXz-kwSRlpU3NQzgQR8pPrxOEr_imahLE6BJMVa6E=s900-c-k-c0x00ffffff-no-rj",
            "https://style.shockvisual.net/wp-content/uploads/2019/07/fx.jpg",
            "https://play-lh.googleusercontent.com/R8Bgl60N7sIT4-o7oIm3SnZRrddAlCyciIu3CncQU_jHZWrDq2TfsFP7_BGNEKPgqZw",
            "https://play-lh.googleusercontent.com/gOdQRt1wE0krK_hm060ql5yHjYffsXvZ9LY3qvlC7pY6p5lRw7jbMKGwUg4chs4n5n2F",
            "https://logowik.com/content/uploads/images/comedy-central.jpg",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ6R-DvEhAoJY85Tuktcps2w24VPtoD8tRcyQ&s",
            "https://seeklogo.com/images/I/investigation-discovery-logo-ED2006ECD6-seeklogo.com.png",
            "https://static.epg.best/pa/TNTSeries.pa.png",
            "https://static.wikia.nocookie.net/youtubepedia/images/9/98/Distrito_Comedia.jpg/revision/latest?cb=20211122040915&path-prefix=es",
            "https://style.shockvisual.net/wp-content/uploads/2023/07/TNT-Novelas.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/6/62/Discovery_kids_logo.png",
            "https://i.ytimg.com/vi/HivPwc0IWXc/hqdefault.jpg",
            "https://i0.wp.com/notasdeactualidad.com/wp-content/uploads/2019/01/caracol-tv.jpg?fit=843%2C575&ssl=1",
            "https://banner2.cleanpng.com/20180404/ace/kisspng-cartoon-network-digital-app-television-android-cartoon-network-5ac59eafaab5f1.4377768715229006556992.jpg",
            "https://logowik.com/content/uploads/images/history-tv-hd3105.logowik.com.webp",
            "https://i.pinimg.com/736x/a1/99/74/a19974ce222a14ccfa0f26b47013c5e0.jpg",
            "https://s.t13.cl/sites/default/files/styles/manualcrop_850x475/public/t13/field-imagen/2018-10/1540060820-ap20.jpg.jpeg?itok=fOs2W_5L",
            "https://static.wikia.nocookie.net/logopedia/images/9/99/Cinecanal_HD_%282010%29.png/revision/latest?cb=20210303154644&path-prefix=es",
            "https://logowik.com/content/uploads/images/space-tv7790.jpg",
            "https://i.pinimg.com/736x/53/15/7a/53157ad3fbc706a055ca4205b5c6f226.jpg",
            "https://static.epg.best/cz/HBO.cz.png",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTYpMcI7zdZ5F20Gxmn-weI6QGX1yeQLUzLng&s",
            "https://pbs.twimg.com/profile_images/702722678877126656/1EWWFB3-_400x400.jpg",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSJMl6hPxItejnzRqMoJqESK6dtT7l-djQEhw&s",
            "https://i.postimg.cc/Dzntck27/24y7.png",
            "https://png.pngtree.com/png-clipart/20210328/original/pngtree-container-cinema-entertainment-popcorn-png-image_6159308.png",
            "https://png.pngtree.com/png-clipart/20210328/original/pngtree-container-cinema-entertainment-popcorn-png-image_6159308.png",
            "https://png.pngtree.com/png-clipart/20210328/original/pngtree-container-cinema-entertainment-popcorn-png-image_6159308.png",
            "https://png.pngtree.com/png-clipart/20210328/original/pngtree-container-cinema-entertainment-popcorn-png-image_6159308.png",
            "https://png.pngtree.com/png-clipart/20210328/original/pngtree-container-cinema-entertainment-popcorn-png-image_6159308.png",
            "https://png.pngtree.com/png-clipart/20210328/original/pngtree-container-cinema-entertainment-popcorn-png-image_6159308.png",
            "https://png.pngtree.com/png-clipart/20210328/original/pngtree-container-cinema-entertainment-popcorn-png-image_6159308.png",
            "https://png.pngtree.com/png-clipart/20210328/original/pngtree-container-cinema-entertainment-popcorn-png-image_6159308.png",
            "https://upload.wikimedia.org/wikipedia/en/0/0d/Simpsons_FamilyPicture.png",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b9/Marvel_Logo.svg/250px-Marvel_Logo.svg.png",
            "https://i.blogs.es/d26168/friends-tiempo/450_1000.jpeg",
            "https://upload.wikimedia.org/wikipedia/en/thumb/e/e8/Walking_Dead_Season_3_Official_Poster.jpg/220px-Walking_Dead_Season_3_Official_Poster.jpg",
            "https://upload.wikimedia.org/wikipedia/en/thumb/e/ea/Thundercats.png/250px-Thundercats.png",
            "https://png.pngtree.com/png-clipart/20210328/original/pngtree-container-cinema-entertainment-popcorn-png-image_6159308.png",
            "https://upload.wikimedia.org/wikipedia/en/6/61/Breaking_Bad_title_card.png",
            "https://upload.wikimedia.org/wikipedia/commons/b/b1/Saint_Seiya_logo.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/4/46/Toy_Story.svg/1200px-Toy_Story.svg.png",
            "https://upload.wikimedia.org/wikipedia/commons/3/3d/The_Flintstones.png",
            "https://www.terra.cl/u/fotografias/m/2022/3/23/f768x1-22152_22279_5050.png",
            "https://upload.wikimedia.org/wikipedia/commons/9/9c/Disney_pixar_logo.png",
            "https://upload.wikimedia.org/wikipedia/en/thumb/f/ff/DreamWorks_Animation_SKG_logo_with_fishing_boy.svg/1200px-DreamWorks_Animation_SKG_logo_with_fishing_boy.svg.png"





            )

        // Enlaces de reproducción existentes
        val videoUrls = listOf(

            "https://www.rtve.es/play/videos/directo/24h/",
            "http://streamsy.online:2999/happy2024/newyear/15",
            "http://streamsy.online:2999/happy2024/newyear/17",
            "http://streamsy.online:2999/happy2024/newyear/18",
            "http://streamsy.online:2999/happy2024/newyear/19",
            "http://streamsy.online:2999/happy2024/newyear/20",
            "http://streamsy.online:2999/happy2024/newyear/21",
            "http://streamsy.online:2999/happy2024/newyear/23",
            "http://streamsy.online:2999/happy2024/newyear/28",
            "http://streamsy.online:2999/happy2024/newyear/32",
            "http://streamsy.online:2999/happy2024/newyear/33",
            "http://streamsy.online:2999/happy2024/newyear/38",
            "http://streamsy.online:2999/happy2024/newyear/39",
            "http://streamsy.online:2999/happy2024/newyear/43",
            "http://streamsy.online:2999/happy2024/newyear/302",
            "http://streamsy.online:2999/happy2024/newyear/1243",
            "http://streamsy.online:2999/happy2024/newyear/50",
            "http://streamsy.online:2999/happy2024/newyear/57",
            "http://streamsy.online:2999/happy2024/newyear/60",
            "http://streamsy.online:2999/happy2024/newyear/61",
            "http://streamsy.online:2999/happy2024/newyear/73",
            "http://streamsy.online:2999/happy2024/newyear/79",
            "http://streamsy.online:2999/happy2024/newyear/82",
            "http://streamsy.online:2999/happy2024/newyear/120",
            "http://streamsy.online:2999/happy2024/newyear/1166",
            "http://streamsy.online:2999/happy2024/newyear/83",
            "http://streamsy.online:2999/happy2024/newyear/92",
            "http://canal-pro.xyz:8080/JokJok/qETRahtG2x/697",
            "http://tvgusplay.info:8080/CwcspkjCgzeZ/m5mknNRdkmc9/439",
            "http://tvgusplay.info:8080/CwcspkjCgzeZ/m5mknNRdkmc9/440",
            "http://tvgusplay.info:8080/CwcspkjCgzeZ/m5mknNRdkmc9/441",
            "http://tvgusplay.info:8080/CwcspkjCgzeZ/m5mknNRdkmc9/442",
            "http://tvgusplay.info:8080/CwcspkjCgzeZ/m5mknNRdkmc9/443",
            "http://tvgusplay.info:8080/CwcspkjCgzeZ/m5mknNRdkmc9/444",
            "http://tvgusplay.info:8080/CwcspkjCgzeZ/m5mknNRdkmc9/445",
            "http://tvgusplay.info:8080/CwcspkjCgzeZ/m5mknNRdkmc9/447",
            "http://tvgusplay.info:8080/CwcspkjCgzeZ/m5mknNRdkmc9/1440",
            "http://tvgusplay.info:8080/CwcspkjCgzeZ/m5mknNRdkmc9/1459",
            "http://tvgusplay.info:8080/CwcspkjCgzeZ/m5mknNRdkmc9/1460",
            "http://tvgusplay.info:8080/CwcspkjCgzeZ/m5mknNRdkmc9/1461",
            "http://tvgusplay.info:8080/CwcspkjCgzeZ/m5mknNRdkmc9/1462",
            "http://tvgusplay.info:8080/CwcspkjCgzeZ/m5mknNRdkmc9/1463",
            "http://tvgusplay.info:8080/CwcspkjCgzeZ/m5mknNRdkmc9/1464",
            "http://tvgusplay.info:8080/CwcspkjCgzeZ/m5mknNRdkmc9/1465",
            "http://tvgusplay.info:8080/CwcspkjCgzeZ/m5mknNRdkmc9/1466",
            "http://tvgusplay.info:8080/CwcspkjCgzeZ/m5mknNRdkmc9/1467",
            "http://tvgusplay.info:8080/CwcspkjCgzeZ/m5mknNRdkmc9/1468",
            "http://tvgusplay.info:8080/CwcspkjCgzeZ/m5mknNRdkmc9/1471",
            "https://youtu.be/5EM3oABfXf0"


            // Nuevos enlaces de video

        )

        // Configurar el adaptador del RecyclerView
        val adapter = ImageAdapter(imageUrls, videoUrls) { url ->
            goToPlayerPage(url)
        }
        recyclerView.adapter = adapter
    }

    // Función para navegar a la actividad de reproducción
    fun goToPlayerPage(url: String) {
        val intent = Intent(this, ActivityMediaPlayer::class.java)
        intent.putExtra("url", url)
        startActivity(intent)
    }
}
