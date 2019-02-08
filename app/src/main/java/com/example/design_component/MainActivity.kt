package com.example.design_component

import android.os.Bundle
import android.util.Base64
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.rv_items

class MainActivity : AppCompatActivity() {

    @Suppress("PropertyName")
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val roomAdapter = RoomAdapter()
//        val gridLayoutManager = GridLayoutManager(this, 2).apply {
//            spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
//                override fun getSpanSize(position: Int): Int {
//                    return when (roomAdapter.getItemViewType(position)) {
//                        1 -> 2
//                        else -> 1
//                    }
//                }
//            }
//        }
        val gridLayoutManager = LinearLayoutManager(this)
        rv_items.apply {
            adapter = roomAdapter
            layoutManager = gridLayoutManager
        }

        roomAdapter.submitItemList(
            listOf(
                Room(
                    "ก้นครัว",
                    "ร้านอาหาร สูตรอาหาร อาหารคาว อาหารหวาน เบเกอรี่ ไอศกรีม",
                    true
                ),
                Room(
                    "กรีนโซน",
                    "อนุรักษ์สิ่งแวดล้อม อนุรักษ์พลังงาน Green Living การออกแบบเพื่อสิ่งแวดล้อม ผลิตภัณฑ์รักษ์โลก เกษตรอินทรีย์",
                    true
                ),
                Room(
                    "กรุงโซล",
                    "เค-ป็อบ ซีรีส์เกาหลี นักแสดงเกาหลี อาหารเกาหลี เที่ยวเกาหลี แฟชั่นเกาหลี ภาษาเกาหลี",
                    true
                ),
                Room(
                    "กล้อง",
                    "กล้องถ่ายรูป กล้อง DSLR กล้องวิดีโอ เทคนิคการถ่ายรูป"
                ),
                Room(
                    "การ์ตูน",
                    "การ์ตูนญี่ปุ่น การ์ตูนไทย การ์ตูนฝรั่ง อนิเมะ วาดการ์ตูน ของสะสมจากการ์ตูน คอสเพลย์"
                ),
                Room(
                    "แก็ดเจ็ต",
                    "Gadget, Action Camera, Drone, Game Console, Smartwatch, Smartband"
                ),
                Room(
                    "แกลเลอรี่",
                    "ภายถ่ายบุคคล ภาพถ่ายทิวทัศน์ ภาพถ่ายมาโคร"
                ),
                Room(
                    "ไกลบ้าน",
                    "เรียนต่อต่างประเทศ ทำงานต่างประเทศ วีซ่า"
                ),
                Room(
                    "จตุจักร",
                    "สัตว์เลี้ยง สุนัข แมว ต้นไม้ จัดสวน ของสะสม งานฝีมือ เกษตรกรรม"
                ),
                Room(
                    "เฉลิมกรุง",
                    "นักร้องนักดนตรี เพลง เครื่องดนตรี คอนเสิร์ต มิวสิควิดีโอ"
                ),
                Room(
                    "เฉลิมไทย",
                    "ภาพยนตร์ ดาราภาพยนตร์ ค่ายหนัง เทศกาลหนัง หนังสั้น"
                ),
                Room(
                    "ชานเรือน",
                    "ครอบครัว ตั้งครรภ์ ตั้งชื่อลูก การเลี้ยงลูก การสอนลูก"
                ),
                Room(
                    "ชายคา",
                    "บ้าน คอนโดมิเนียม ตกแต่งบ้าน เฟอร์นิเจอร์ เครื่องใช้ไฟฟ้า เครื่องครัว"
                ),
                Room(
                    "ซิลิคอนวัลเลย์",
                    "คอมมือใหม่ อินเทอร์เน็ต ซอฟต์แวร์ ฮาร์ดแวร์ เกม เขียนโปรแกรม Gadget"
                ),
                Room(
                    "ดิโอลด์สยาม",
                    "ผู้สูงอายุ สุขภาพผู้สูงอายุ ชีวิตหลังเกษียณ สิทธิผู้สูงอายุ ท่องเที่ยวผู้สูงอายุ"
                ),
                Room(
                    "โต๊ะเครื่องแป้ง",
                    "เครื่องสำอาง เสริมสวย แฟชั่น เครื่องประดับ ลดความอ้วน"
                ),
                Room(
                    "ถนนนักเขียน",
                    "แต่งนิยาย เรื่องสั้น กลอน นิทาน"
                ),
                Room(
                    "บลูแพลนเน็ต",
                    "เที่ยวไทย เที่ยวต่างประเทศ ทะเล ภูเขา เกาะ น้ำตก ดำน้ำ สายการบิน"
                ),
                Room(
                    "บางขุนพรหม",
                    "ละคร นักแสดง ซีรี่ส์ รายการโทรทัศน์ สถานีโทรทัศน์"
                ),
                Room(
                    "บางรัก",
                    "ความรัก แต่งงาน พรีเวดดิ้ง ปัญหาชีวิตคู่"
                ),
                Room(
                    "พรหมชาติ",
                    "ดูดวง ฮวงจุ้ย ไพ่ยิปซี ทำนายฝัน พระเครื่อง"
                ),
                Room(
                    "พันทิป",
                    "ข้อเสนอแนะถึงพันทิป วิธีการใช้งานพันทิป กิจกรรมพันทิป"
                ),
                Room(
                    "ภูมิภาค",
                    "ภาคเหนือ ภาคอีสาน ภาคกลาง ภาคตะวันออก ภาคตะวันตก ภาคใต้"
                ),
                Room(
                    "มาบุญครอง",
                    "โทรศัพท์มือถือ Smartphone Tablet iOS Android"
                ),
                Room(
                    "รวมมิตร",
                    "รวมกระทู้จากทุกห้อง"
                ),
                Room(
                    "รัชดา",
                    "รถยนต์ มอเตอร์ไซค์ เครื่องเสียงรถยนต์ แต่งรถ การจราจร"
                ),
                Room(
                    "ราชดำเนิน",
                    "การเมือง รัฐศาสตร์ กฎหมาย สภาผู้แทน รัฐบาล ฝ่ายค้าน พรรคการเมือง"
                ),
                Room(
                    "ไร้สังกัด",
                    "กระทู้อื่นๆ ที่ไม่สังกัดห้องไหนเลย"
                ),
                Room(
                    "ศาลาประชาคม",
                    "กฎหมาย ปัญหาสังคม ปัญหาชีวิต เศรษฐกิจ คุ้มครองผู้บริโภค"
                ),
                Room(
                    "ศาสนา",
                    "ศาสนาพุทธ ศาสนาคริสต์ ศาสนาอิสลาม เที่ยววัด ทำบุญ"
                ),
                Room(
                    "ศุภชลาศัย",
                    "กีฬา ฟุตบอล บาสเกตบอล มวยสากล กอล์ฟ จักรยาน นักกีฬา"
                ),
                Room(
                    "สยามสแควร์",
                    "ชีวิตวัยรุ่น การเรียน โรงเรียน มหาวิทยาลัย ความรักวัยรุ่น การ์ตูน เกม"
                ),
                Room(
                    "สวนลุมพินี",
                    "สุขภาพกาย สุขภาพจิต โรคมะเร็ง โรคไมเกรน โรคภูมิแพ้ ปวดประจำเดือน"
                ),
                Room(
                    "สินธร",
                    "หุ้น เศรษฐกิจ การลงทุน LTF RMF ธนาคาร เงินตราต่างประเทศ"
                ),
                Room(
                    "สีลม",
                    "การบริหารจัดการ การตลาด ทรัพยากรบุคคล งานขาย SME ภาษีนิติบุคคล"
                ),
                Room(
                    "หว้ากอ",
                    "วิทยาศาสตร์ วิศวกรรม เทคโนโลยี ฟิสิกส์ ดาราศาสตร์ อวกาศ"
                ),
                Room(
                    "ห้องสมุด",
                    "หนังสือ หนังสือนิยาย ภาษาไทย ภาษาจีน ภาษาอังกฤษ ปรัชญา ประวัติศาสตร์"
                ),
                Room(
                    "หอศิลป์",
                    "ศิลปะ ภาพวาด ประวัติศาสตร์ศิลป์ สื่อประสม Graphic Design"
                )
            )
        )
    }

    private fun encode(input: String): String {
        return Base64.encodeToString(
            Base64.encode(
                Base64.encode(
                    input.toByteArray(charset("UTF-8")),
                    Base64.NO_WRAP
                ).reversedArray(),
                Base64.NO_WRAP
            ).reversedArray(),
            Base64.NO_WRAP
        )
    }

    private fun decode(input: String): String {
        return String(
            Base64.decode(
                Base64.decode(
                    Base64.decode(input, Base64.NO_WRAP).reversedArray(),
                    Base64.NO_WRAP
                ).reversedArray(), Base64.NO_WRAP
            )
        )
    }
}
