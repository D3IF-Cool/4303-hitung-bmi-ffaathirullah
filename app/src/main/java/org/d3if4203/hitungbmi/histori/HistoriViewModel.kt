package org.d3if4203.hitungbmi.histori

import androidx.lifecycle.ViewModel
import org.d3if4203.hitungbmi.db.BmiDao

class HistoriViewModel(db: BmiDao) : ViewModel() {
    val data = db.getLastBmi()
}
