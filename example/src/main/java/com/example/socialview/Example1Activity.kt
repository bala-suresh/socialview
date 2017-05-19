package com.example.socialview

import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import butterknife.BindView
import butterknife.BindViews
import com.hendraanggrian.socialview.OnSocialClickListener
import com.hendraanggrian.socialview.SocialView
import com.hendraanggrian.widget.SocialTextView

/**
 * @author Hendra Anggrian (hendraanggrian@gmail.com)
 */
class Example1Activity : BaseActivity(), OnSocialClickListener {

    override val contentView: Int
        get() = R.layout.activity_example1

    @BindView(R.id.toolbar_example1) lateinit var toolbar: Toolbar
    @BindViews(R.id.socialtextview_example1_1, R.id.socialtextview_example1_2, R.id.socialtextview_example1_3) lateinit var socialTextViews: Array<SocialTextView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(toolbar)
        for (textView in socialTextViews)
            textView.setOnSocialClickListener(this)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home)
            finish()
        return super.onOptionsItemSelected(item)
    }

    override fun onSocialClick(v: TextView, @SocialView.Type type: Int, text: CharSequence) {
        Toast.makeText(this, String.format("%s clicked:\n%s", type, text), Toast.LENGTH_SHORT).show()
    }
}