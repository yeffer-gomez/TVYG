package com.example.tvyg
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tvyg.databinding.ActivityListBinding

class ListActivity : AppCompatActivity() {
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
            "https://http2.mlstatic.com/D_NQ_NP_696208-MLM75727749784_042024-O.webp",
            "https://pbs.twimg.com/media/F98bUfrb0AARdPe.jpg:large",
            "https://pbs.twimg.com/media/GLjgITiXIAA4r5M.jpg",
            "https://www.universalpictures.com.mx/tl_files/content/movies/trolls_3/posters/02.jpg",
            "https://www.themoviedb.org/t/p/original/fN6Bxw7tk9PTO99N7OzcJmjs0rN.jpg",
            "https://m.media-amazon.com/images/I/71n18AvUy8L._AC_UF894,1000_QL80_.jpg",
            "https://image.tmdb.org/t/p/w500//8cdWjvZQUExUUTzyp4t6EDMubfO.jpg",
            "http://cvr.iks.cc/cvr/vod/cinecam/s28eYemGh3mKXp.jpg",
            "https://image.tmdb.org/t/p/w500//8cdWjvZQUExUUTzyp4t6EDMubfO.jpg",
            "https://image.tmdb.org/t/p/w500//ycpxvpNyrkzsydwvLTUNixRWrdQ.jpg",
            "https://image.tmdb.org/t/p/w500//wj1VRcVsh39nkxLkZP8tuGd96tc.jpg",
            "https://image.tmdb.org/t/p/w500//xJ9tLOj7KNmSQWYjV7nTmgIldIx.jpg",
            "https://image.tmdb.org/t/p/w500//kN5H9EhUqDWBAsbnbt2XNhS7BFe.jpg",
            // Nuevas URLs de imágenes
            "https://image.tmdb.org/t/p/w500/40UPlmnQcG71KSmjijksZjbsH2q.jpg",
            "https://image.tmdb.org/t/p/w500/2e853FDVSIso600RqAMunPxiZjq.jpg",
            "https://image.tmdb.org/t/p/w500/plcZXvI310FkbwIptvd6rqk63LP.jpg",
            "https://image.tmdb.org/t/p/w500/dWyxPokAp4eiJXWriYbNvU2v1V.jpg",
            "https://image.tmdb.org/t/p/w500/tg1LwZgPKcvxaIgWauX8F5Cs6HS.jpg",
            "https://image.tmdb.org/t/p/w500/n7h5qQErebTkp5YfbDxcu9sPxc8.jpg",
            "https://image.tmdb.org/t/p/w500/5gzzkR7y3hnY8AD1wXjCnVlHba5.jpg",
            "https://image.tmdb.org/t/p/w500/jEf96axaZhZQEu9ORVtEujBTG9p.jpg",
            "https://image.tmdb.org/t/p/w500/4c3Yoa0r7hI3KkqBToD1ONAtPh2.jpg",
            "https://image.tmdb.org/t/p/w500/4mP5ahudkqmq9gsbC9kd6sIW3WY.jpg",
            "https://image.tmdb.org/t/p/w500/2NYd7jKFnilcIOUfDI8o2TOuCmu.jpg",
            "https://image.tmdb.org/t/p/w500/4EONm3medZBNfHhost4taqrje1r.jpg",
            "https://image.tmdb.org/t/p/w500/9YDW8dCrQyRpppK5985hKY1Mc8X.jpg",
            "https://image.tmdb.org/t/p/w500/0k1LB40kAuKJzmIfCfT1F9QRYFM.jpg",
            "https://image.tmdb.org/t/p/w500/cAoAgzOCxSytYBqqCQulhXNR3LB.jpg",
            "https://image.tmdb.org/t/p/w500/wB6ez9v9HzSLplIy6m00SPIkuH7.jpg",
            "https://image.tmdb.org/t/p/w500/of6Ds591FJTKoBHYjDFzH6jlTyK.jpg",
            "https://image.tmdb.org/t/p/w500/tlu71AgaL3EQBBCNGsAwZLPbV5D.jpg",
            "https://image.tmdb.org/t/p/w500/pLAeWgqXbTeJ2gQtNvRmdIncYsk.jpg",
            "https://image.tmdb.org/t/p/w500/kAVRgw7GgK1CfYEJq8ME6EvRIgU.jpg",
            "https://image.tmdb.org/t/p/w500/lr11mCT85T1JanlgjMuhs9nMht4.jpg",
            "https://image.tmdb.org/t/p/w500/b9t3w1loraDh7hjdWmpc9ZsaYns.jpg",
            "https://image.tmdb.org/t/p/w500/wKiOkZTN9lUUUNZLmtnwubZYONg.jpg",
            "https://image.tmdb.org/t/p/w500/awkREv7AGElLvl68GPuPMZcd5HK.jpg",
            "https://image.tmdb.org/t/p/w500/fR49hZdFJ6ZtRS23JW79VYmZgI7.jpg",
            "https://image.tmdb.org/t/p/w500/6FsGeIp7heHm5eh4tIxTzHIRxmt.jpg",
            "https://image.tmdb.org/t/p/w500/1HOYvwGFioUFL58UVvDRG6beEDm.jpg",
            "https://image.tmdb.org/t/p/w500/n5nH4IcSmlYgAil6NOVvn6d35BH.jpg",
            "https://image.tmdb.org/t/p/w500/1rHJJcmCd4cyGoF9dVJ2Nw4KQph.jpg",
            "https://image.tmdb.org/t/p/w500/qpPMewlugFaejXjz4YNDnpTniFX.jpg",
            "https://image.tmdb.org/t/p/w500/AcKVlWaNVVVFQwro3nLXqPljcYA.jpg",
            "https://i.imgur.com/Jv9QHqQ.png",
            "https://i.imgur.com/Jv9QHqQ.png",
            "https://i.imgur.com/Jv9QHqQ.png",
            "https://image.tmdb.org/t/p/w500/3uTnw1XahydeVkwFzY5xq5aFUh7.jpg",
            "https://image.tmdb.org/t/p/w500/vx1u0uwxdlhV2MUzj4VlcMB0N6m.jpg",
            "https://image.tmdb.org/t/p/w500/s9sUK1vAaOcxJfKzNTszrNkPhkH.jpg",
            "https://image.tmdb.org/t/p/w500/Qotf3QgDqUZEW6pfQl2BPxZCRn.jpg",
            "https://image.tmdb.org/t/p/w500/d0RgJjlxH3uEPRpo3TROI2uiKwC.jpg",
            "https://image.tmdb.org/t/p/w500/v31MsWhF9WFh7Qooq6xSBbmJxoG.jpg",
            "https://image.tmdb.org/t/p/w500/sv1xJUazXeYqALzczSZ3O6nkH75.jpg",
            "https://image.tmdb.org/t/p/w500/cF0pwv6ce82pPVCIEzB5ArnuIZx.jpg",
            "https://image.tmdb.org/t/p/w500/gOnmaxHo0412UVr1QM5Nekv1xPi.jpg",
            "https://image.tmdb.org/t/p/w500/tvX2JltXjmpHLQ7BBijyVc9STv4.jpg",
            "https://image.tmdb.org/t/p/w500/3Ib8vlWTrAKRrTWUrTrZPOMW4jp.jpg",
            "https://image.tmdb.org/t/p/w500/oha0LfOP5L6uZlCkphWGy1Q2Kzy.jpg",
            "https://image.tmdb.org/t/p/w500/fDdbuCr0DpJpG2i4XzI0l3otInX.jpg",
            "https://image.tmdb.org/t/p/w500/ngl2FKBlU4fhbdsrtdom9LVLBXw.jpg",
            "https://image.tmdb.org/t/p/w500/ra3xm8KFAkwK0CdbPRkfYADJYTB.jpg",
            "https://image.tmdb.org/t/p/w500/c21ON7BZn0jwdNl6ibZ1vhXJmpy.jpg",
            "https://image.tmdb.org/t/p/w500/m4WQ1dBIrEIHZNCoAjdpxwSKWyH.jpg",
            "https://image.tmdb.org/t/p/w500/ecz83StK0eK8Rnio8TCmhbtVU98.jpg",
            "https://image.tmdb.org/t/p/w500/3Ei59AR64x6dMZfWobPCkZjbqTL.jpg",
            "https://image.tmdb.org/t/p/w500/ng0bdozu6NBdGQIsru1oXyzNxc6.jpg",
            "https://image.tmdb.org/t/p/w500/2NUXG94dGMKYgJL1BkJGKynMb3l.jpg",
            "https://image.tmdb.org/t/p/w500/bJfls3xZqEyPyXWONQLcMX6KxIC.jpg",
            "https://image.tmdb.org/t/p/w500/9JBEPLTPSm0d1mbEcLxULjJq9Eh.jpg",
            "https://image.tmdb.org/t/p/w500/qNBAXBIQlnOThrVvA6mA2B5ggV6.jpg",
            "https://image.tmdb.org/t/p/w500/5bFK5d3mVTAvBCXi5NPWH0tYjKl.jpg",
            "https://image.tmdb.org/t/p/w500/7he8glf7j41d3amgf4Nbpt3HVq1.jpg",
            "https://image.tmdb.org/t/p/w500/bOFaAXmWWXC3Rbv4u4uM9ZSzRXP.jpg",
            "https://image.tmdb.org/t/p/w500/4LaOaPkt0pICwcuJcpCQQ0ocy7y.jpg",
            "https://image.tmdb.org/t/p/w500/r7HEBkkRN93d3eFBZgPJfRaob5p.jpg",
            "https://i.imgur.com/Jv9QHqQ.png",
            "https://image.tmdb.org/t/p/w500/xmbU4JTUm8rsdtn7Y3Fcm30GpeT.jpg",
            "https://image.tmdb.org/t/p/w500/4CclCDyQXBBgz62Qtp3CoflQE5g.jpg",
            "https://i.imgur.com/Jv9QHqQ.png",
            "https://image.tmdb.org/t/p/w500/y37QvulwOJ1uv0onnDB4ocWEQZn.jpg",
            "https://image.tmdb.org/t/p/w500/6a1iqhfM0Y31kNPOSNPIuPrsYQ6.jpg",
            "https://i.imgur.com/Jv9QHqQ.png",
            "https://image.tmdb.org/t/p/w500/12qaWw3KntFPoOCEJFSCLAuL7rN.jpg",
            "https://image.tmdb.org/t/p/w500/1BIoJGKbXjdFDAqUEiA2VHqkK1Z.jpg",
            "https://image.tmdb.org/t/p/w500/dSU7wJBbBdcx1XtTzH83iJcn3TI.jpg",
            "https://image.tmdb.org/t/p/w500/fP3VvqUjEBjawxZHL4sYCq2ZdJD.jpg",
            "https://image.tmdb.org/t/p/w500/crzoVQnMzIrRfHtQw0tLBirNfVg.jpg",
            "https://image.tmdb.org/t/p/w500/1MJNcPZy46hIy2CmSqOeru0yr5C.jpg",
            "https://i.imgur.com/Jv9QHqQ.png",
            "https://image.tmdb.org/t/p/w500/eLwfFQFX5XKGIbRCVfRx6IlO7aJ.jpg",
            "https://image.tmdb.org/t/p/w500/6xo2OFHncAymOQtzHwPFF0nyHPl.jpg",
            "https://image.tmdb.org/t/p/w500/aWeKITRFbbwY8txG5uCj4rMCfSP.jpg",




            )

        // Enlaces de reproducción existentes
        val videoUrls = listOf(
            "http://notabasica.com/612132/Garfield.Fuera.de.Casa.2024.720p-Dual-Lat%20%281%29.mp4",
            "http://notabasica.com/612132/El.planeta.de.los.simios.Nuevo.reino.2024.720p-Dual-Lat%20%281%29.mp4",
            "http://notabasica.com/612132/Amigos.Imaginarios.2024.1080P-Dual-Lat.mp4",
            "http://notabasica.com/612132/Trolls%203%20-%20Se%20Arm%C3%B3%20la%20Banda.mp4",
            "http://notabasica.com/612132/FiveNightsAtFreddys.mp4",
            "http://notabasica.com/612132/Winnie.the.Pooh.Blood.and.Honey.2023.lati.mp4",
            "http://208.88.245.81/nuevo/deadpool.y.wolverine.2024.dual.mkv",
            "http://cdnvod-1.iks.cc:4013/vodsd/wNn3CppS90BxvdY/cinecam/s28eYemGh3mKXp.mp4",
            "https://spyderrock.com/cGh83509-d.mp4",
            "http://208.88.245.81/nuevo/silver.y.el.libro.dlos.suenos.dual2023.mkv",
            "http://208.88.245.81/nuevo/los.menospreciados.dual.2024.mkv",
            "http://208.88.245.81/nuevo/xsiempre.rbd.latino.2024.mkv",
            "http://208.88.245.81/nuevo/sp.no.apto.para.menores.dual.2023.mkv",
            // Nuevos enlaces de video
            "http://208.88.245.85/nuevo/la.usurpadora2023.latino.mkv",
            "http://208.88.245.85/nuevo/la.sociedad.dla.nieve.latino.2024.mkv",
            "http://208.88.245.85/nuevo/la.sirenita.2023dual.mkv",
            "http://208.88.245.85/nuevo/princesa.cisne.2023dual.mkv",
            "http://208.88.245.85/nuevo/la.oscuridad.delaluz.del.mundo.latino2023.mkv",
            "http://208.88.245.85:80/nuevo/la.nina.dela.comunion.2023cast.mkv",
            "http://208.88.245.85/nuevo/la.monja2.dual2023.mkv",
            "http://208.88.245.85/nuevo/la.magia.dla.navidad.dual.2023.mkv",
            "http://208.88.245.85/nuevo/la.madre.dual.2023.mkv",
            "http://208.88.245.85/nuevo/ligadlajusticia.mundo.belico.dual2023.mkv",
            "http://208.88.245.85/nuevo/la.hija.del.prisionero.dual2023.mkv",
            "http://208.88.245.85/nuevo/la.gran.seduccion.2023.latino.mkv",
            "http://208.88.245.85/nuevo/la.fiebre.dlos.peluches.beanie.dual2023.mkv",
            "http://208.88.245.85/nuevo/la.familia.claus3.dual2023.mkv",
            "http://208.88.245.85/nuevo/la.elefanta.del.mago.dual2023.mkv",
            "http://208.88.245.85/nuevo/la.dama.del.silencio.dual2023.mkv",
            "http://208.88.245.85/nuevo/la.calle.dela.navidad.dual2023.mkv",
            "http://notabasica.com/612132/Fresh.2022.lati.mp4",
            "http://notabasica.com/612132/Father.Stu.2022.lati.mp4",
            "http://notabasica.com/612132/JurassicWorldDominio.mkv",
            "http://notabasica.com/612132/El.Telefono.Negro.SRREGIO.NET.mkv",
            "http://notabasica.com/612132/lightyear.2022.SRREGIO.mp4",
            "http://notabasica.com/612132/Minions.NaceUnVillano.SrRegio.Net.mp4",
            "http://notabasica.com/612132/Predator_Prey_SrRegio.Net.mkv",
            "http://notabasica.com/612132/Las.leyendas.El.origen.2021.lati.mp4",
            "http://notabasica.com/612132/365.Days.Part.III.2022.lati.mp4",
            "http://notabasica.com/612132/Luck.2022.lati.mp4",
            "http://notabasica.com/612132/Backseat.Driver.2020..lati.mp4",
            "http://notabasica.com/612132/Mentada.de.padre.2019.lati.mp4",
            "http://notabasica.com/612132/DC.League.of.Super.Pets.2022.lati.mp4",
            "http://notabasica.com/612132/Nope.2022.lati.mp4",
            "http://notabasica.com/612132/Hocus.Pocus.2.2022.lati.mp4",
            "http://notabasica.com/612132/black.adam.baja.calidad.php?f=.mp4",
            "http://notabasica.com/612132/Night.at.the.Museum.Kahmunrah.Rises.Again.2022.lati.mp4",
            "http://notabasica.com/612132/Cube.2021.lati.mp4",
            "http://notabasica.com/612132/Guillermo.del.Toros.Pinocchio.2022.lati.mp4",
            "http://notabasica.com/612132/Emancipaci%C3%B3n.2022.lati.mp4",
            "http://notabasica.com/612132/Huevitos.congelados.2022.lati.mp4",
            "http://notabasica.com/612132/Puss.in.Boots.The.Last.Wish.2022.lati.mp4",
            "http://notabasica.com/612132/The.Menu.2022.lati.mp4",
            "http://notabasica.com/612132/Black.Panther.Wakanda.Forever.2022.lati.mp4",
            "http://notabasica.com/612132/M%C3%ADrame.2021.lati.mp4",
            "http://notabasica.com/612132/Cocaine.Bear.2023.lati.mp4",
            "http://notabasica.com/612132/Luther.The.Fallen.Sun.2023.lati.mp4",
            "http://notabasica.com/612132/The.Jack.in.the.Box.Awakening.2022.lati.mp4",
            "http://notabasica.com/612132/El.Oso.Vicioso.2023.lati.mp4",
            "http://notabasica.com/612132/The.Exorcism.of.God.2022.lati.mp4",
            "https://objectstorage.us-phoenix-1.oraclecloud.com/n/axa4wow3dcia/b/bucket-20201001-1658/o/2023pelis%2Fabril%2FVer%20Ant-Man%20and%20the%20Wasp-%20Quantumania%20online%20HD%20-%20Cuevana%202%20Espa%C3%B1ol.mp4",
            "https://objectstorage.us-phoenix-1.oraclecloud.com/n/axa4wow3dcia/b/bucket-20201001-1658/o/2023pelis%2Fabril%2FVer%20Chupa%20Online%20Castellano%20Latino%20Subtitulada%20HD%20-%20HDFull.mp4",
            "https://objectstorage.us-ashburn-1.oraclecloud.com/n/idvrlfgimket/b/cubostudio/o/peliculas%2Fpelisabr23%2Fcristianas%2FVer%20La%20Historia%20M%C3%A1s%20Grande%20Jam%C3%A1s%20Contada%20(1965)%20Online%20-%20Cuevana%203%20Peliculas%20Online.mp4",
            "https://objectstorage.us-ashburn-1.oraclecloud.com/n/idvrlfgimket/b/cubostudio/o/peliculas%2Fpelisabr23%2Fcristianas%2FVer%20Ben-Hur%20(1959)%20Online%20-%20Cuevana%203%20Peliculas%20Online.mp4",
            "https://objectstorage.us-ashburn-1.oraclecloud.com/n/idvrlfgimket/b/cubostudio/o/peliculas%2Fpelisabr23%2Fcristianas%2FVer%20Hijo%20de%20Dios%20online%20HD%20-%20Cuevana%202%20Espa%C3%B1ol.mp4",
            "https://objectstorage.us-ashburn-1.oraclecloud.com/n/idvrlfgimket/b/cubostudio/o/peliculas%2Fpelisabr23%2Fcristianas%2FVer%20Los%20Diez%20Mandamientos%20(1956)%20Online%20Latino%20HD%20-%20Cuevana%20HD.mp4",
            "https://objectstorage.us-ashburn-1.oraclecloud.com/n/idvrlfgimket/b/cubostudio/o/peliculas%2Fpelisabr23%2Fcristianas%2FVer%20Mar%C3%ADa%20Magdalena%20Online%20Gratis%20(%E2%9A%9C%EF%B8%8F%202018)%20-%20CUEVANA3.mp4",
            "https://objectstorage.us-ashburn-1.oraclecloud.com/n/idvrlfgimket/b/cubostudio/o/peliculas%2Fpelisabr23%2Fcristianas%2FVer%20Pablo%20Apostol%20De%20Cristo%20(2018)%20Online%20-%20Cuevana%203%20Peliculas%20Online.mp4",
            "https://objectstorage.us-ashburn-1.oraclecloud.com/n/idvrlfgimket/b/cubostudio/o/peliculas%2Fpelisabr23%2Fcristianas%2FVer%20La%20Resurrecci%C3%B3n%20de%20Cristo%20(2016)%20Online%20-%20Cuevana%203%20Peliculas%20Online.mp4",
            "https://objectstorage.us-phoenix-1.oraclecloud.com/n/axa4wow3dcia/b/bucket-20201001-1658/o/2023pelis%2Fabril%2FVer%20El%20exorcista%20del%20papa%20Online%20Castellano%20Latino%20Subtitulada%20HD%20-%20HDFull.mp4",
            "https://objectstorage.us-phoenix-1.oraclecloud.com/n/axa4wow3dcia/b/bucket-20201001-1658/o/2023pelis%2Fabril%2FVer%20S%C3%BAper%20Mario%20Bros-%20La%20pel%C3%ADcula%20Online%20Castellano%20Latino%20Subtitulada%20HD%20-%20HDFull.mp4",
            "http://notabasica.com/612132/Space.Jam.Una.Nueva.Era.2021.1080P-SrRegio.Net.mkv",
            "http://notabasica.com/612132/Un.rescate.de.huevitos.2021.1080p-lat-SRREGIO.NET.mkv",
            "http://notabasica.com/612132/R%C3%A1pidos.Y.Furiosos.9.%282021%29.1080P-Dual-Lat-SRREGIO.NET.mkv",
            "http://notabasica.com/612132/You%27re.not.alone..2021.1080p-dual-lat-SRREGIO.NET.mkv",
            "http://notabasica.com/612132/No.Respires.2.2021.1080P-Dual-Lat-SRREGIO.NET.mkv",
            "http://notabasica.com/612132/La.Calle.Del.Terror.%28Parte%201%29.1080P-SrRegio.Net.mkv",
            "http://notabasica.com/612132/Free.guy.2021.1080p-dual-lat-SRREGIO.NET.com.mkv",
            "http://notabasica.com/612132/Halloween.Kills.2021.1080P.Dual.Lat.Cine-SRREGIO.NET.mkv",
            "http://notabasica.com/612132/Isabelle.2018.1080p-dual-lat-SRREGIO.NET.mkv",
            "http://notabasica.com/612132/Una.Momia.En.Halloween.%282021%29.720P.Dual.Lat.srregio.net.mkv",
            "http://notabasica.com/612132/Polaroid.2019.1080P.Dual.Lat.SRREGIO.NET.mkv",
            "http://notabasica.com/612132/Nobody.Sleeps.In.The.Woods.Tonight.2.2021.1080P.Dual.Lat.SRREGIO.NET.mkv",
            "http://notabasica.com/612132/A.un.paso.de.m%C3%AD.2021.1080p-lat-SRREGIO.NET.mkv",
            "http://notabasica.com/612132/Shang.Chi.And.The.Legend.Of.The.Ten.Rings.2021.1080P-Dual-Lat-SRREGIO.NET.mkv",
            "http://notabasica.com/612132/Red.Notice.2021.1080P-Dual-Lat-Cine-SRREGIO.NET.mkv",
            "http://notabasica.com/612132/Home.Sweet.Home.Alone.2021.1080P.Dual.Lat.Cine-SRREGIO.NET.mkv",
            "https://notabasica.com/php/SR_REGIO_502122_/volver_al_futuro.php?f=.mp4",
            "http://notabasica.com/612132/Venom.let.there.be.carnage.2021.1080p-dual-lat-srregio.net.mkv",
            "http://notabasica.com/php/SR_REGIO_526022_/bienvenido.al.mundo.franco.escamilla.php?f=.mp4",
            "http://notabasica.com/612132/Diary.of.a.wimpy.kid.2021.1080p-dual-lat-SRREGIO.NET.mkv",
            "http://notabasica.com/612132/The.whole.truth.2021.1080p-dual-lat-SRREGIO.NET.mkv",
            "http://notabasica.com/612132/Sing.2.2021.1080P-Dual-Lat-SRREGIO.NET.mkv",

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
