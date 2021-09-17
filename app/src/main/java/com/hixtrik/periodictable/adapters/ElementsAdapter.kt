package com.hixtrik.periodictable.adapters

import android.app.AlertDialog
import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View.INVISIBLE
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hixtrik.periodictable.R
import com.hixtrik.periodictable.databinding.ElementItemBinding
import com.hixtrik.periodictable.models.Element
import kotlin.random.Random

//┌──────────────────────────┐
//│ Created by Taha ARICAN   │
//│ aricantaha06@gmail.com   │            
//│ 15.09.2021               │
//└──────────────────────────┘
class ElementsAdapter(val elementList: List<Element>) :
    RecyclerView.Adapter<ElementsAdapter.ElementViewHolder>() {
    inner class ElementViewHolder(val binding: ElementItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(element: Element, resources: Resources, context: Context) {
            with(binding) {
                if (element.visibility != null) itemView.visibility = INVISIBLE
                elementName = element.name
                elementNumber = element.number.toString()
                elementSymbol = element.symbol
                elementBackground = when (element.xpos) {
                    1 -> getColor(resources, R.color.x1_y1_background)
                    2 -> getColor(resources, R.color.x2_y2_background)
                    3, 4, 5, 6, 7, 8, 9, 10, 11, 12 -> getColor(resources, R.color.x3_y4_background)
                    17 -> getColor(resources, R.color.x17_y2_background)
                    18 -> getColor(resources, R.color.x18_y1_background)
                    else -> getColor(resources, R.color.x2_y2_background)
                }
                elementFont = when (element.xpos) {
                    1 -> getColor(resources, R.color.x1_y1_font)
                    2 -> getColor(resources, R.color.x2_y2_font)
                    3, 4, 5, 6, 7, 8, 9, 10, 11, 12 -> getColor(resources, R.color.x3_y4_font)
                    17 -> getColor(resources, R.color.x17_y2_font)
                    18 -> getColor(resources, R.color.x18_y1_font)
                    else -> getColor(resources, R.color.x2_y2_font)
                }
                when (element.number) {
                    5, 6, 14, 32, 33, 51, 52, 84 -> {
                        elementBackground = getColor(resources, R.color.x13_y2_background)
                        elementFont = getColor(resources, R.color.x13_y2_font)
                    }
                    13, 31, 49, 50, 81, 82, 83, 113, 114, 115, 116 -> {
                        elementBackground = getColor(resources, R.color.x13_y3_background)
                        elementFont = getColor(resources, R.color.x13_y3_font)
                    }
                    7, 8, 15, 16, 34 -> {
                        elementBackground = getColor(resources, R.color.x15_y2_background)
                        elementFont = getColor(resources, R.color.x15_y2_font)
                    }
                }
                if (element.ypos == 9) {
                    elementBackground = getColor(resources, R.color.x3_y9_background)
                    elementFont = getColor(resources, R.color.x3_y9_font)
                } else if (element.ypos == 10) {
                    elementBackground = getColor(resources, R.color.x3_y10_background)
                    elementFont = getColor(resources, R.color.x3_y10_font)
                }
                itemView.setOnClickListener {
                    val builder = AlertDialog.Builder(context)
                    val dialog = builder.create()
                    val dialogView = inflate(context, R.layout.detail_dialog, null)
                    val dialogElementNumber =
                        dialogView.findViewById<TextView>(R.id.dialogElementNumber)
                    val dialogElementName =
                        dialogView.findViewById<TextView>(R.id.dialogElementName)
                    val dialogElementAtomicWeight =
                        dialogView.findViewById<TextView>(R.id.dialogElementAtomicWeight)
                    val dialogElementSymbol =
                        dialogView.findViewById<TextView>(R.id.dialogElementSymbol)
                    val dialogElementSummary =
                        dialogView.findViewById<TextView>(R.id.dialogElementSummary)
                    val dialogImageView = dialogView.findViewById<ImageView>(R.id.dialogImageView)
                    dialogElementNumber.text = element.number.toString()
                    dialogElementAtomicWeight.text =
                        "Atomic Weight: ${element.atomic_mass}"
                    dialogElementName.text = element.name
                    dialogElementSymbol.text = element.symbol
                    dialogElementSummary.text = element.summary

                    when (Random.nextInt(1, 7)) {
                        1 -> dialogImageView.setImageResource(R.drawable.bismuth)
                        2 -> dialogImageView.setImageResource(R.drawable.iron)
                        3 -> dialogImageView.setImageResource(R.drawable.copper)
                        4 -> dialogImageView.setImageResource(R.drawable.iodine)
                        5 -> dialogImageView.setImageResource(R.drawable.antimony)
                        6 -> dialogImageView.setImageResource(R.drawable.carbon)
                    }
                    dialog.setView(dialogView)
                    R.style.Animation_Design_BottomSheetDialog

                    if (dialog.window != null) dialog.window!!.attributes.windowAnimations =
                        R.style.SlidingDialogAnimation
                    dialog.show()
                }
            }
        }

        private fun getColor(resources: Resources, id: Int) =
            resources.getString(0 + id)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ElementViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val binding = ElementItemBinding.inflate(inflater)
        return ElementViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return elementList.size
    }

    override fun onBindViewHolder(holder: ElementViewHolder, position: Int) {
        val resources = holder.itemView.context.resources
        holder.bind(elementList[position], resources, holder.itemView.context)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }
}