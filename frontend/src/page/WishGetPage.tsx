import React, { ReactElement, useEffect, useState } from 'react';
import BackLayout from '../component/wishget/Backlayout';
import NavBar from '../component/NavBar';
import useWishStore from '../wishstore';
import { GotWish } from '../interface/Wish';
import axios from 'axios';
import { deleteWish, getWish } from '../service/WishService';
import CommentCreateModal from '../component/comment/CommentCreateModal';
import CommentModal from '../component/comment/CommentModal';
import { CreatedComment } from '../interface/Comment';
import { createComment, getAllComment } from '../service/CommentService';
import { useNavigate } from 'react-router-dom';
import CommentPostIt from '../component/comment/CommentPostIt';

const WishGetPage: React.FC = () => {
  const [showCreateCommentModal, setShowCreateCommentModal] =
    useState<boolean>(false);
  const [showCommentModal, setShowCommentModal] = useState<boolean>(false);
  const [comment, setComment] = useState<Array<GotWish> | null>();
  const [commentValue, setCommentValue] = useState<string>('');
  const [wish, setWish] = useState<GotWish | undefined>();
  const { wishId } = useWishStore();
  const navigator = useNavigate();
  // const handleShowCommentModal = ()=>{

  // };

  const handleShowCommentCreateModal = () => {
    setShowCreateCommentModal((pre) => !pre);
  };

  const handleShowCommentModal = () => {
    setShowCommentModal((pre) => !pre);
  };

  const handleGetWish = async (id: number) => {
    const response = await getWish(id);
    console.log(response);
    setWish(response);
  };
  const handleGetComment = async (id: number) => {
    const response = await getAllComment(id);
    setComment(response);
  };
  const handleDeleteWish = async () => {
    const response = await deleteWish(wishId);
    navigator('/');
  };
  const handleCommentInputChange = (
    event: React.ChangeEvent<HTMLInputElement>,
  ) => {
    setCommentValue(event.target.value);
    console.log(commentValue);
  };

  const handleCommentCreate = async () => {
    const requestBody: CreatedComment = {
      content: commentValue,
      wishId: wishId,
    };
    const response = await createComment(requestBody);
    console.log(response);
    setShowCreateCommentModal((pre) => !pre);
    setCommentValue('');
  };
  useEffect(() => {
    handleGetWish(wishId);
    handleGetComment(wishId);
  }, []);

  return (
    <BackLayout>
      <NavBar></NavBar>
      <div className="m-auto mt-[20vh] w-[30%] h-[50%] flex flex-col justify-center items-center gap-10">
        {/* 조건부 렌더링으로 undefined 예외 처리 */}
        <p className="text-[32px] font-bold text-center mt-[10vh]">
          {wish?.title}
        </p>
        <p className="text-[16px] text-center mt-[1vh]">{wish?.category}</p>
        <p className="text-[20px] font-bold text-center mt-[1vh]">
          {wish?.content}
        </p>
        <div className="w-[100%] h-[100px] flex justify-center gap-5">
          <button
            className="w-[100px] h-[50px] bg-red-300 text-[16px]"
            onClick={handleDeleteWish}
          >
            소원성취
          </button>
          <button
            className="w-[100px] h-[50px] bg-red-300 text-[16px]"
            onClick={handleShowCommentCreateModal}
          >
            댓글작성
          </button>
          <button
            className="w-[100px] h-[50px] bg-red-300 text-[16px]"
            onClick={handleShowCommentModal}
          >
            댓글조회
          </button>
        </div>
      </div>
      {showCommentModal ? (
        <CommentModal
          className="left-[28%] bottom-[10%]"
          onClose={handleShowCommentModal}
        >
          {comment.map((item) => (
            <CommentPostIt content={item.content} key={item.id} />
          ))}
        </CommentModal>
      ) : null}

      {showCreateCommentModal ? (
        <CommentCreateModal
          showModal={showCreateCommentModal}
          onClose={handleShowCommentCreateModal}
          commentValue={commentValue}
          onInput={handleCommentInputChange}
          onSubmit={handleCommentCreate}
        ></CommentCreateModal>
      ) : null}
    </BackLayout>
  );
};

export default WishGetPage;
