package com.strategair.strategy.common.component

import android.os.Bundle
import com.strategair.strategy.common.R

class FileReaderActivity : ImmersiveActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_file_reader)
    }
}
