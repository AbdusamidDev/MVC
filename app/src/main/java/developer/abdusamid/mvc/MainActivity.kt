package developer.abdusamid.mvc

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import developer.abdusamid.mvc.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity(), Observer {
    private lateinit var binding: ActivityMainBinding
    private lateinit var myModel: MyModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        myModel = MyModel()
        myModel.addObserver(this)
        binding.apply {
            button.setOnClickListener { myModel.setValue(0) }
            button2.setOnClickListener { myModel.setValue(1) }
            button3.setOnClickListener { myModel.setValue(2) }
        }
    }

    @SuppressLint("SetTextI18n")
    override fun update(p0: Observable?, p1: Any?) {
        binding.button.text = "Count: ${myModel.getValue(0)}"
        binding.button2.text = "Count: ${myModel.getValue(1)}"
        binding.button3.text = "Count: ${myModel.getValue(2)}"
    }
}