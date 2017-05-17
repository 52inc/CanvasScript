/*
 * Copyright (c) 2017 52inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ftinc.canvasscript.params;

import android.graphics.Canvas;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class ScaleParamsTest {

    private static final float SX = 10f;
    private static final float SY = 10f;
    private static final float PX = 15f;
    private static final float PY = 15f;

    @Mock Canvas canvas;


    @Test
    public void shouldScaleCanvasWithDefaultPivot() {
        ScaleParams params = new ScaleParams(SX, SY);

        int result = params.draw(canvas);

        verify(canvas).scale(SX, SY);
        assertThat(result, is(CanvasParams.NO_SAVE));
    }


    @Test
    public void shouldScaleCanvasWithCustomPivot() {
        ScaleParams params = new ScaleParams(SX, SY, PX, PY);

        int result = params.draw(canvas);

        verify(canvas).scale(SX, SY, PX, PY);
        assertThat(result, is(CanvasParams.NO_SAVE));
    }
}