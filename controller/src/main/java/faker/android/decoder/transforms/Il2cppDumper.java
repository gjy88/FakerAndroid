package faker.android.decoder.transforms;

import faker.android.decoder.exception.BinaryException;
import faker.android.decoder.exception.FakerAndroidException;
import faker.android.decoder.il2cpp.Il2cppBinary;
import faker.android.decoder.pipeline.AndroidProject;
import faker.android.decoder.pipeline.Apk;
import faker.android.decoder.pipeline.Transform;
import faker.android.decoder.pipeline.TransformInvocation;

public class Il2cppDumper extends Transform  {
    public Il2cppDumper(Apk apk, AndroidProject androidProject) {
        super(apk, androidProject);
    }

    @Override
    public void transform(TransformInvocation transformInvocation) {
        transformInvocation.callBack("il2cpp dumper");
        try {
            Il2cppBinary.dumpIl2cpp(apk.getApkFile(),androidProject.getCpp());
        } catch (BinaryException e) {
            e.printStackTrace();
        } catch (FakerAndroidException e) {
            e.printStackTrace();
        }
    }
}