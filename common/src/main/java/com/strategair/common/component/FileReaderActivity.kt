package com.strategair.common.component

import android.os.Bundle
import com.strategair.common.R

class FileReaderActivity : ImmersiveActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_file_reader)
    }
}
