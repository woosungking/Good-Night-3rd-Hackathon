import axios from 'axios';
import { CreatedComment } from '../interface/Comment';

export const createComment = async (createdComment: CreatedComment) => {
  try {
    const resposne = await axios.post(
      'http://localhost:8080/api/v1/comment/create',
      createdComment,
      {
        headers: {
          'Content-Type': 'application/json',
          Accept: 'application/json',
        },
      },
    );
    console.log(resposne.data);
    return resposne;
  } catch (error) {
    console.log('댓글을 저장하는 도중 오류 발생 ::: => ', error);
  }
};
export const getAllComment = async (wishId: number) => {
  try {
    const response = await axios.get(
      `http://localhost:8080/api/v1/comment/${wishId}`,
    );
    console.log(response);
    console.log(response.data);
    return response.data;
  } catch (error) {
    console.log(
      'ID:',
      wishId,
      '소원을 가져오는 도중 오류가 발생하였습니다 ::: => ',
      error,
    );
  }
};
export const deleteComment = async () => {};
export const patchComment = async () => {};
