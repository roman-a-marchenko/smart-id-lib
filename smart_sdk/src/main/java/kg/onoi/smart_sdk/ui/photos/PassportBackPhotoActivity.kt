package kg.onoi.smart_sdk.ui.photos

import kg.onoi.smart_sdk.models.Constant
import kg.onoi.smart_sdk.models.PhotoType
import kg.onoi.smart_sdk.ui.base.BaseActivity
import kg.onoi.smart_sdk.ui.base.SimpleActivity
import kg.onoi.smart_sdk.ui.registration_steps.RegistrationStepsActivity
import kg.onoi.smart_sdk.utils.NavigatorFacade

class PassportBackPhotoActivity : BasePhotoActivity() {

    override fun onSuccessPhotoUploaded() {
        NavigatorFacade.startNextActivity(this)
    }

    override fun onBackPressed() {
        RegistrationStepsActivity.start(this)
        finish()
    }

    companion object {
        fun start(activity: SimpleActivity) {
            activity.startActivity(
                activity
                    .createIntent(PassportBackPhotoActivity::class)
                    .putExtra(Constant.Extra.PHOTO_TYPE, PhotoType.PASSPORT_BACK.name)
            )
        }

        fun startForResult(activity: BaseActivity<*>) {
            activity.startActivityForResult(
                activity.createIntent(PassportBackPhotoActivity::class)
                    .putExtra(Constant.Extra.PHOTO_TYPE, PhotoType.PASSPORT_BACK.name)
                    .putExtra(Constant.Extra.FOR_MODERATION, true), 0
            )
        }

    }

}