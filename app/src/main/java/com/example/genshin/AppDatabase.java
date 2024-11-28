package com.example.genshin;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Personaje.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public static AppDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(
                            context.getApplicationContext(),
                            AppDatabase.class, "db"
                    ).addMigrations(MIGRACION_1_2).fallbackToDestructiveMigration().build();
        }
        return INSTANCE;
    }

    public abstract PersonajeDAO getPersonajeDao();

    public static final Migration MIGRACION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE Personaje ADD COLUMN Descripcion TEXT");

            database.execSQL("INSERT INTO Personaje (id, nombre, elemento, tipoarma, rareza, icono, imgGacha, Descripcion) VALUES (90,'Chasca','Anemo','Arco',5,'https://static.wikia.nocookie.net/gensin-impact/images/0/03/Chasca_Icon.png/revision/latest?cb=20241120025626','https://static.wikia.nocookie.net/gensin-impact/images/8/8c/Character_Chasca_Full_Wish.png/revision/latest?cb=20241121134538','La mediadora de Tlalocán, pacificadora de mil conflictos.');");
            database.execSQL("INSERT INTO Personaje (id, nombre, elemento, tipoarma, rareza, icono, imgGacha, Descripcion) VALUES (89,'Ororon','Electro','Arco',4,'https://static.wikia.nocookie.net/gensin-impact/images/5/5e/Ororon_Icon.png/revision/latest?cb=20241014100711','https://static.wikia.nocookie.net/gensin-impact/images/7/76/Character_Ororon_Full_Wish.png/revision/latest?cb=20241121134547','Un joven de los Augures Vientonocturno que vive en la naturaleza junto a toda clase de seres vivos.');");

            database.execSQL("UPDATE Personaje SET Descripcion = 'Siempre enérgica y llena de vida, Amber es la mejor exploradora de los Caballeros de Favonius, aunque también es la única...' WHERE ID = 1;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'El gran estratega de los Caballeros de Favonius. Se rumorea que procede de un lugar de fuera de Mondstadt.' WHERE ID = 2;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'La perezosa pero sabia bibliotecaria de los Caballeros de Favonius. En realidad, fue considerada por la Academia de Sumeru como su graduada más sobresaliente en los últimos dos siglos.' WHERE ID = 3;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'Todos los habitantes de Mondstadt adoran a Bárbara. Ella vio por primera vez la palabra \"ídolo\" en una revista.' WHERE ID = 4;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'Un chico que vive entre los lobos en el Reino de los Lobos de Mondstadt, lejos de la civilización. Es ágil como un relámpago.' WHERE ID = 5;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'Una reconocida chef de Liyue. Le apasiona la cocina y sobresale al hacer sus platos calientes y picantes.' WHERE ID = 6;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'Líder de la Flota Crux Meridianam. Es una jefa bastante desenfadada y franca.' WHERE ID = 7;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'Un joven con una espada larga al que puede verse frecuentemente en las librerías. Tiene un corazón de oro y anhela la justicia y la igualdad para todos.' WHERE ID = 8;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'Ninguang, conocida como el \"Equilibrio Celestial\", es miembro de las \"Siete Estrellas de Liyue\". Su riqueza es insuperable en todo Teyvat.' WHERE ID = 9;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'Una chica misteriosa que se hace llamar \"Princesa del Juicio\". Siempre camina junto con un cuervo oscuro llamado Oz.' WHERE ID = 10;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'El chico aventurero de Mondstadt. Su naturaleza amable no va acorde con su mala suerte.' WHERE ID = 11;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'La criada de confianza de los Caballeros de Favonius. Sueña con convertirse algún dia en una de ellos.' WHERE ID = 12;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'Un joven exorcista procedente de una familia de exorcistas. Hace todo lo que puede para reprimir su propia \"positividad congénita\".' WHERE ID = 13;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'Una alquimista e investigadora de la escuela de bioalquimia que siente curiosidad por todo.' WHERE ID = 14;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'La justa y rigurosa Caballera de Dandelion, y Gran Maestra Intendente de los Caballeros de Favonius de Mondstadt.' WHERE ID = 15;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'El magnate del imperio vinícola de Mondstadt, inigualable en todos los sentidos.' WHERE ID = 16;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'Una aprendiz y recolectora de hierbas en la Farmacia Bubu. Una zombi con una tez blanca como el hueso, de pocas palabras y emociones.' WHERE ID = 17;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'Una misteriosa y joven astróloga que se hace llamar \"Astróloga Mona Megistus\". Está convencida de que posee las habilidades para estar a la altura del título. Erudita y orgullosa.' WHERE ID = 18;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'El Equilibrio Terrenal de las Siete Estrellas de Liyue. Tiene su opinión sobre el gobierno de Rex Lapis en Liyue, pero, en verdad, a los dioses les gustan bastante los escépticos como ella.' WHERE ID = 19;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'Uno de los muchos bardos de Mondstadt que deambula libremente por las calles y callejones de la ciudad.' WHERE ID = 20;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'Una visitante frecuente de los calabozos de los Caballeros de Favonius, la maestra de explosiones de Mondstadt. La llaman \"el Sol Fugitivo\".' WHERE ID = 21;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'Una joven cuya sangre no es humana por completo. Es la popular cantinera de la taberna Cola de Gato.' WHERE ID = 22;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'El undécimo de Los Once, también conocido como \"Nobile\". Es temido por sus proezas en batalla.' WHERE ID = 23;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'La única rockera de Liyue. A través de la música y la pasión de sus canciones, hace una crítica de los prejuicios de la sociedad.' WHERE ID = 24;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'Misterioso asesor de la Funeraria El Camino. Erudito y con información sobre todo tipo de cosas.' WHERE ID = 25;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'Alquimista Jefe de los Caballeros de Favonius y Capitán de la Compañia de Investigación. Lo llaman el \"Príncipe de la Roca Caliza\".' WHERE ID = 26;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'La secretaria del Pabellón Yuehai. La sangre de bestia iluminada Chilin fluye por sus venas.' WHERE ID = 27;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'Un Yaksha y Adeptus que protege Liyue. También llamado el \"Gran Cazador de Demonios\" o \"Guardián Yaksha\".' WHERE ID = 28;");
            database.execSQL("UPDATE Personaje SET Descripcion = '77.ª directora de la Funeraria El Camino. Pese a su corta edad, ya es la principal encargada de todos los asuntos funerarios de Liyue.' WHERE ID = 29;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'Una monja que, aparte de por su ropa, nadie diría que pertenece al clero. Su frialdad hacia todo la hace extremadamente incisiva y siempre actúa en solitario.' WHERE ID = 30;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'Una reconocida asesora legal que vive en Liyue. Esta joven tan perspicaz tiene parte de sangre de bestia iluminada.' WHERE ID = 31;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'La Caballera de la Marea, procedente de una familia con un gran linaje y Capitana de la Compañía de Reconocimiento de los Caballeros de Favonius. Aunque es descendiente de la antigua aristocracia, se unió a los Caballeros de Favonius, sus archienemigos, algo que sigue siendo un gran enigma para toda Mondstadt hasta hoy en día.' WHERE ID = 32;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'Un samurái errante de Inazuma que actualmente se hospeda en la Flota Crux Meridianam de Liyue. El corazón de este amable y libre joven encierra sus muchas cargas del pasado.' WHERE ID = 33;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'La descendiente del clan Kamisato, perteneciente a la Comisión Yashiro de Inazuma. Una persona solemne, refinada, inteligente y tenaz.' WHERE ID = 34;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'Una ninja perteneciente a Los Ocelos. Muy bajita y siempre con aspecto de no haber dormido suficiente.' WHERE ID = 35;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'La dueña de la tienda Pirotecnia Naganohara y Reina del Festival de Verano. Deposita los deseos de la gente en sus artesanales fuegos artificiales.' WHERE ID = 36;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'Antes era una paria, pero hoy en día es una cazadora excepcionalmente ágil. Siempre está preparada para hacer uso de su arco y sus flechas cuando es necesario.' WHERE ID = 37;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'La general de la Comisión Tenryou. Es una persona audaz, firme y muy buena en combate.' WHERE ID = 38;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'Su excelencia, la todopoderosa Narukami, quien le prometió al pueblo de Inazuma la inmutable eternidad.' WHERE ID = 39;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'La Sacerdotisa Divina y quien controla todos los asuntos de la Isla Watatsumi.' WHERE ID = 40;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'El amo de llaves del clan Kamisato y un intermediario muy activo en Inazuma.' WHERE ID = 41;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'El gran general de las tropas Watatsumi. Sus subordinados confían plenamente en él.' WHERE ID = 42;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'El primer gran líder de la Banda de Arataki, muy activo en la zona de Hanamizaka de la Ciudad de Inazuma. ¿Nunca habías oído hablar de la Banda de Arataki? ¿En serio?' WHERE ID = 43;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'Una renombrada cantante de ópera de Liyue que es experta tanto en la composición de obras como en el canto. Su estilo es único, exquisito y delicado, como su propia persona.' WHERE ID = 44;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'Una discípula de los Adeptus con una mirada perdida. Al haber vigido recluida en las montañas de Liyue, su carácter es tan frío y distante como el de los Adeptus.' WHERE ID = 45;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'La Suma Sacerdotisa del Gran Santuario Narukami y editora jefa de la Editorial Yae. Bajo su increible encanto esconde una inteligencia y una astucia inimaginables.' WHERE ID = 46;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'Joven promesa y actual líder del clan Kamisato de la Comisión Yashiro. Refinado y educado, siempre tiene una forma de solucionar las cosas.' WHERE ID = 47;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'Una misteriosa persona que dice trabajar para el Ministerio de Asuntos Civiles, pero que \"no existe\" según los registros del propio Ministerio.' WHERE ID = 48;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'La hábil y confiable subjefa de la Banda de Arataki. Menos mal que está ella, si no, la Banda de Arataki no tendría nada de \"hábil\" ni \"confiable\".' WHERE ID = 49;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'El joven y talentoso detective de la Comisión Tenryou. Intuitivo, sagaz y muy inteligente.' WHERE ID = 50;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'Una guardabosques en prácticas que suele rondar por el Bosque Avidya. Detrás de su apasionado carácter se esconde una personalidad más bien introvertida.' WHERE ID = 51;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'Un joven erudito experto en botánica que desempeña el cargo de guarda forestal en el Bosque Avidya. Es muy franco, entusiasta y bueno instruyendo a las personas con menos conocimientos.' WHERE ID = 52;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'Una impredecible comerciante itinerante cuya mayor pasión es el Mora contante y sonante.' WHERE ID = 53;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'Custodia de la Aldea Aaru. Esta muchacha con un ojo claro ámbar es descendiente del Rey Deshret.' WHERE ID = 54;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'Gran Juez de la matra y supervisor de los eruditos de la Academia de Sumeru. Cuando trabaja, es incluso más eficiente que la \"Gran Vayuvyastra\" creada por la Facultad Kshahrewar.' WHERE ID = 55;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'La famosa bailarina del Teatro Zubayr. Su estilo de danza es elegante y agraciado, y posee un carácter puro y bondadoso.' WHERE ID = 56;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'Un pajarito enjaulado en el Santuario Surasthana que solo puede contemplar el mundo desde sus sueños.' WHERE ID = 57;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'Una estudiante de la Facultad Rtawahist especializada en astrología teórica. A veces con sonambulismo, otras veces con insomnio, esta chica siempre tiene problemas de sueño.' WHERE ID = 58;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'Una erudita \"con cien años de antigüedad\" a la que le encanta recalcar que tiene más experiencia que los demás. Posee unos amplios conocimientos sobre textos antiguos y sobre todo tipo de mecanismos.' WHERE ID = 59;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'Un joven errante de identidad enigmática. Viste como un asceta, pero no actúa como tal.' WHERE ID = 60;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'La discípula más joven de Caminante Errante. Es una \"pequeña adulta\" de lo más dulce y considerada.' WHERE ID = 61;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'El actual escriba de la Academia de Sumeru, un hombre de gran inteligencia y talento. Vive su vida libremente y es prácticamente imposible de encontrar.' WHERE ID = 62;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'Dehya, miembro de Los Eremitas, una organización de mercenarios del desierto de Sumeru. Es valiente, poderosa y goza de una gran reputación en dicha organización.' WHERE ID = 63;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'Un joven caballero procedente de una familia normal. Es el tímido y precavido topógrafo de avanzada de la Compañia de Reconocimiento.' WHERE ID = 64;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'Un célebre arquitecto de Sumeru que se preocupa demasiado por las cosas. Es un fanático de la estética, pero está atrapado por la realidad.' WHERE ID = 65;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'El dueño de la Farmacia Bubu, siempre con una serpiente blanca llamada Changsheng colgándole del cuello. Gran conocedor de la medicina, sus auténticas intenciones son un verdadero misterio.' WHERE ID = 66;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'Una repartidora de Komaniya Exprés, una empresa de envíos de Inazuma. Es una nejomata a la que le encanta su trabajo y la sociedad humana.' WHERE ID = 67;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'Una ayudante de magia poco habladora y expresiva. Es tan impredecible como un felino.' WHERE ID = 68;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'Un astuto y hábil mago de Fontaine que siempre se gana al público con sus ingeniosos trucos y su elocuencia.' WHERE ID = 69;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'Un retraído joven experto en el arte del submarinismo. Bajo su gélido y distante talento, se oculta un corazón sin mácula alguna.' WHERE ID = 70;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'El juez supremo de Fontaine. Es conocido por su impecable imparcialidad y abnegación.' WHERE ID = 71;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'El duque del Fuerte Merópide y gobernante oculto del oscuro fondo marino.' WHERE ID = 72;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'La vivaracha reportera de <<El Pájaro de Vapor>>, siempre en busca de la verdad.' WHERE ID = 73;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'El foco de atención absoluto del escenario durante los juicios, hasta que la obra termina y el público rompe a aplaudir.' WHERE ID = 74;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'La actual presidenta de Spina di Rosula, una jefa adorable con un profundo sentido de la responsabilidad.' WHERE ID = 75;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'La capitana de la Unidad Especial de Seguridad y Vigilancia. Su corazón siempre late por la justicia, y su mosquete solo apunta a los criminales.' WHERE ID = 76;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'Escolta de la Agencia de Transporte Seguro Cofrespada y líder del grupo Bestias Místicas Poderosas.' WHERE ID = 77;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'Una de los poderosos e iluminados Adeptus del Desfiladero Jueyun, conocida como Preservadora de Nubes. Gran maestra de la mecánica interesada en el mundo de los humanos y conocida en él con el nombre de \"Xianyun\".' WHERE ID = 78;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'La dueña de la Sastrería Chiori y una famosa diseñadora de moda de Fontaine.' WHERE ID = 79;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'La Sota, la cuarta de Los Once de los Fatui y una diplomática fría e implacable. Es conocida como \"Padre\" por todos los niños de la Casa de la Hoguera, a quien temen, pero de quien también dependen.' WHERE ID = 80;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'El heredero del Templo del Silencio. Portador de secretos y procedente del desierto.' WHERE ID = 81;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'Una verduga del justiciazgo invicta que defiende la Corte de Fontaine a capa y espada.' WHERE ID = 82;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'La melusina enfermera jefa del Fuerte Merópide. CUida por igual a todos los reclusos de esta prisión submarina.' WHERE ID = 83;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'Una perfumista de Fontaine que guarda sus secretos en sus frascos.' WHERE ID = 84;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'Una joven guerrera de Nanatzcayan agraciada con el nombre antiguo de \"Uthabiti\". Esta muchacha persistente y de buen corazón siempre encuentra oportunidades de crecimiento ante cualquier contratiempo.' WHERE ID = 85;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'Una guía de Natlan muy famosa que lleva una tienda de suministros acuáticos, así como una surfista experta en todo tipo de deportes de agua.' WHERE ID = 86;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'Un cazasaurios de Huitztlán experto en calcular el precio de las cosas.' WHERE ID = 87;");
            database.execSQL("UPDATE Personaje SET Descripcion = 'Una maestra forjanombres de Natatzcayan experta en encontrar el equilibrio entre el ajetreo del trabajo y una vida cómoda.' WHERE ID = 88;");
        }
    };
}
